package com.training;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database {
	private final static String DB_URL = "jdbc:sqlite:library.db";
	private static Connection connection;

	static void addBook(String title, String author, String genre, String publicationDate, String isbn,
			boolean available) throws SQLException {
		connection = DriverManager.getConnection(DB_URL);
		Statement statement = connection.createStatement();
		String insertSQL = String.format(
				"INSERT INTO books (title, author, genre, publication_date, isbn, available) VALUES ('%s', '%s', '%s', '%s', '%s', '%d')",
				title, author, genre, publicationDate, isbn, (available ? 1 : 0));
		statement.executeUpdate(insertSQL);
		statement.close();
		connection.close();
	}

	static void addBorrower(String name, String email, String phone, String address) throws SQLException {
		connection = DriverManager.getConnection(DB_URL);
		Statement statement = connection.createStatement();
		String insertSQL = String.format(
				"INSERT INTO borrowers (name, email, phone, address) VALUES ('%s', '%s', '%s', '%s')", name, email,
				phone, address);
		statement.executeUpdate(insertSQL);
		statement.close();
		connection.close();
	}

	static void addCheckout(String bookID, String borrowerID, String coutdate, String duedate, String returnDate)
			throws SQLException {
		boolean checkBookId = isIdExists("books", bookID);
		boolean checkBorrowerId = isIdExists("borrowers", borrowerID);

		if (checkBookId == false || checkBorrowerId == false) {
			connection.close();
			throw new SQLException();
		}

		connection = DriverManager.getConnection(DB_URL);
		Statement statement = connection.createStatement();
		String insertSQL = String.format(
				"INSERT INTO checkouts (book_id, borrower_id, checkout_date, due_date, return_date) VALUES ('%s', '%s', '%s', '%s', '%s')",
				bookID, borrowerID, coutdate, duedate, returnDate);
		statement.executeUpdate(insertSQL);
		statement.close();
		connection.close();
	}

	private static boolean isIdExists(String tableName, String id) throws SQLException {
		connection = DriverManager.getConnection(DB_URL);
		String query = "SELECT COUNT(*) FROM " + tableName + " WHERE id = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, id);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.getInt(1) > 0;
			}
		} finally {
			connection.close();
		}
	}

	static void createDatabase() {
		try {
			connection = DriverManager.getConnection(DB_URL);
			Statement statement = connection.createStatement();

			statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "title TEXT NOT NULL," + "author TEXT NOT NULL," + "genre TEXT NOT NULL,"
					+ "publication_date TEXT NOT NULL," + "isbn TEXT NOT NULL," + "available INTEGER NOT NULL" + ")");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS borrowers (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL," + "email TEXT NOT NULL," + "phone TEXT NOT NULL," + "address TEXT NOT NULL"
					+ ")");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS checkouts (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "book_id INTEGER NOT NULL," + "borrower_id INTEGER NOT NULL," + "checkout_date TEXT NOT NULL,"
					+ "due_date TEXT NOT NULL," + "return_date TEXT,"
					+ "FOREIGN KEY(book_id) REFERENCES books(\"id\") ON DELETE CASCADE ON UPDATE CASCADE,"
					+ "FOREIGN KEY(borrower_id) REFERENCES borrowers(\"id\") ON DELETE CASCADE ON UPDATE CASCADE"
					+ ")");

			statement.close();
		} catch (SQLException e) {
			System.err.println("Error creating database: " + e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error closing connection: " + e.getMessage());
			}
		}
	}

	static void delete(String tableName, String id) throws SQLException {
		connection = DriverManager.getConnection(DB_URL);

		PreparedStatement preparedStatement;
		if (tableName.equals("books")) {
			preparedStatement = connection.prepareStatement("DELETE FROM checkouts WHERE book_id = ?");
			preparedStatement.clearParameters();
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		}

		if (tableName.equals("borrowers")) {
			preparedStatement = connection.prepareStatement("DELETE FROM checkouts WHERE borrower_id = ?");
			preparedStatement.clearParameters();
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		}

		preparedStatement = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
		preparedStatement.clearParameters();

		preparedStatement.setString(1, id);

		int k = preparedStatement.executeUpdate();
		connection.close();

		if (k == 0) {
			throw new SQLException();
		}
	}

	static void refreshTables(DefaultTableModel bookModel, DefaultTableModel borrowerModel,
			DefaultTableModel checkoutModel) {
		refreshBooksTable(bookModel);
		refreshBorrowersTable(borrowerModel);
		refreshCheckoutsTable(checkoutModel);

	}

	private static void refreshBooksTable(DefaultTableModel bookModel) {
		bookModel.setRowCount(0);
		try {
			connection = DriverManager.getConnection(DB_URL);
			String selectBooksQuery = "SELECT * FROM books";
			PreparedStatement selectBooksStmt = connection.prepareStatement(selectBooksQuery);
			ResultSet bookResults = selectBooksStmt.executeQuery();
			while (bookResults.next()) {
				Object[] bookData = { bookResults.getInt("id"), bookResults.getString("title"),
						bookResults.getString("author"), bookResults.getString("genre"),
						bookResults.getString("publication_date"), bookResults.getString("isbn"),
						bookResults.getBoolean("available") };
				bookModel.addRow(bookData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error closing connection: " + e.getMessage());
			}
		}
	}

	private static void refreshBorrowersTable(DefaultTableModel borrowerModel) {
		borrowerModel.setRowCount(0);
		try {
			connection = DriverManager.getConnection(DB_URL);
			String selectBorrowersQuery = "SELECT * FROM borrowers";
			try (PreparedStatement selectBorrowersStmt = connection.prepareStatement(selectBorrowersQuery)) {
				ResultSet borrowerResults = selectBorrowersStmt.executeQuery();
				while (borrowerResults.next()) {
					Object[] borrowerData = { borrowerResults.getInt("id"), borrowerResults.getString("name"),
							borrowerResults.getString("email"), borrowerResults.getString("phone"),
							borrowerResults.getString("address") };
					borrowerModel.addRow(borrowerData);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error closing connection: " + e.getMessage());
			}
		}
	}

	private static void refreshCheckoutsTable(DefaultTableModel checkoutModel) {
		checkoutModel.setRowCount(0);
		try {
			connection = DriverManager.getConnection(DB_URL);
			String selectCheckoutsQuery = "SELECT * FROM checkouts";
			try (PreparedStatement selectCheckoutsStmt = connection.prepareStatement(selectCheckoutsQuery)) {
				ResultSet checkoutResults = selectCheckoutsStmt.executeQuery();
				while (checkoutResults.next()) {
					Object[] checkoutData = { checkoutResults.getInt("id"), checkoutResults.getInt("book_id"),
							checkoutResults.getInt("borrower_id"), checkoutResults.getString("checkout_date"),
							checkoutResults.getString("due_date"), checkoutResults.getString("return_date") };
					checkoutModel.addRow(checkoutData);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error closing connection: " + e.getMessage());
			}
		}
	}
}
