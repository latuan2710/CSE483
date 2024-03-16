package app;

import app.model.Book;
import app.model.Borrower;
import app.model.Record;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PresentationLayer extends javax.swing.JFrame {

    private final String[] bookColumns = {"ID", "Title", "Author", "Genre", "Quantity"};
    private final String[] borrowerColumns = {"ID", "Name", "Address", "Email", "Phone"};
    private final String[] recordColumns = {"ID", "Book Title", "Borrower Name"};
    private final BusinessLogicTier businessLogicTier;
    private DefaultTableModel bookModel, borrowerModel, recordModel;

    public PresentationLayer() {
        this.businessLogicTier = new BusinessLogicTier();
        initComponents();
        createTableModels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookTitle = new javax.swing.JTextField();
        bookAuthor = new javax.swing.JTextField();
        bookGenre = new javax.swing.JTextField();
        bookQuality = new javax.swing.JTextField();
        addBookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        removeBookId = new javax.swing.JTextField();
        removeBookButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        borrowerName = new javax.swing.JTextField();
        borrowerAddress = new javax.swing.JTextField();
        borrowerPhone = new javax.swing.JTextField();
        borrowerEmail = new javax.swing.JTextField();
        addBorrowerButton = new javax.swing.JButton();
        removeBorrowerId = new javax.swing.JTextField();
        removeBorrowerButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        borrowerTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bookTitleRecord = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        borrowerNameRecord = new javax.swing.JTextField();
        addRecordButton = new javax.swing.JButton();
        removeRecordId = new javax.swing.JTextField();
        removeRecordButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        recordTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Title");

        jLabel2.setText("Author");

        jLabel3.setText("Genre");

        jLabel4.setText("Quality");

        bookQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookQualityActionPerformed(evt);
            }
        });

        addBookButton.setText("Add");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(bookTable);

        removeBookButton.setText("Delete");
        removeBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBookButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookTitle)
                            .addComponent(bookAuthor)
                            .addComponent(bookGenre)
                            .addComponent(bookQuality)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBookButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeBookId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBookButton)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bookAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bookGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bookQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBookButton)
                    .addComponent(removeBookId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBookButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book", jPanel1);

        jLabel5.setText("Name");

        jLabel6.setText("Address");

        jLabel7.setText("Phone");

        jLabel8.setText("Email");

        addBorrowerButton.setText("Add");
        addBorrowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBorrowerButtonActionPerformed(evt);
            }
        });

        removeBorrowerButton.setText("Delete");
        removeBorrowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBorrowerButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(borrowerTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrowerName)
                            .addComponent(borrowerAddress)
                            .addComponent(borrowerPhone)
                            .addComponent(borrowerEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addBorrowerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeBorrowerId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeBorrowerButton)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(borrowerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(borrowerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(borrowerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(borrowerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBorrowerButton)
                    .addComponent(removeBorrowerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBorrowerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Borrower", jPanel2);

        jLabel9.setText("Book Title");

        jLabel10.setText("Borrower Name");

        addRecordButton.setText("Add");
        addRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecordButtonActionPerformed(evt);
            }
        });

        removeRecordButton.setText("Delete");
        removeRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRecordButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(recordTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bookTitleRecord)
                                .addComponent(borrowerNameRecord)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(addRecordButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removeRecordId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(removeRecordButton)))
                    .addContainerGap())
                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(bookTitleRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(borrowerNameRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addRecordButton)
                        .addComponent(removeRecordId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(removeRecordButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Record", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookQualityActionPerformed

    }//GEN-LAST:event_bookQualityActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        try {
            String title = bookTitle.getText();
            String author = bookAuthor.getText();
            String genre = bookGenre.getText();
            int quantity = Integer.parseInt(bookQuality.getText());

            boolean isSuccess = businessLogicTier.registerBook(title, author, genre, quantity);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Book added successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error adding book. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error adding book. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void removeBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookButtonActionPerformed
        try {
            int bookId = Integer.parseInt(removeBookId.getText());
            boolean isSuccess = businessLogicTier.removeBook(bookId);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Book removed successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error removing book. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error removing book. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_removeBookButtonActionPerformed

    private void addBorrowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBorrowerButtonActionPerformed
        try {
            String name = borrowerName.getText();
            String address = borrowerAddress.getText();
            String email = borrowerEmail.getText();
            String phone = borrowerPhone.getText();

            boolean isSuccess = businessLogicTier.registerBorrower(name, address, email, phone);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Borrower added successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error adding borrower. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error adding borrower. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_addBorrowerButtonActionPerformed

    private void removeBorrowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBorrowerButtonActionPerformed
        try {
            int borrowerId = Integer.parseInt(removeBorrowerId.getText());
            boolean isSuccess = businessLogicTier.removeBorrower(borrowerId);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Borrower removed successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error removing borrower. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error removing borrower. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_removeBorrowerButtonActionPerformed

    private void addRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecordButtonActionPerformed
        try {
            String name = borrowerNameRecord.getText();
            String title = bookTitleRecord.getText();

            boolean isSuccess = businessLogicTier.borrowBook(title, name);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Record added successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error adding record. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error adding record. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_addRecordButtonActionPerformed

    private void removeRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRecordButtonActionPerformed
        try {
            int recordId = Integer.parseInt(removeRecordId.getText());
            boolean isSuccess = businessLogicTier.removeRecord(recordId);
            if (isSuccess) {
                JOptionPane.showMessageDialog(addBookButton, "Record removed successfully.");
            } else {
                JOptionPane.showMessageDialog(addBookButton, "Error removing record. Please try again.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(addBookButton, "Error removing record. Please try again.");
        } finally {
            this.refreshBookTable();
            this.refreshBorrowerTable();
            this.refreshRecordTable();
        }
    }//GEN-LAST:event_removeRecordButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PresentationLayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addBorrowerButton;
    private javax.swing.JButton addRecordButton;
    private javax.swing.JTextField bookAuthor;
    private javax.swing.JTextField bookGenre;
    private javax.swing.JTextField bookQuality;
    private javax.swing.JTable bookTable;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JTextField bookTitleRecord;
    private javax.swing.JTextField borrowerAddress;
    private javax.swing.JTextField borrowerEmail;
    private javax.swing.JTextField borrowerName;
    private javax.swing.JTextField borrowerNameRecord;
    private javax.swing.JTextField borrowerPhone;
    private javax.swing.JTable borrowerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable recordTable;
    private javax.swing.JButton removeBookButton;
    private javax.swing.JTextField removeBookId;
    private javax.swing.JButton removeBorrowerButton;
    private javax.swing.JTextField removeBorrowerId;
    private javax.swing.JButton removeRecordButton;
    private javax.swing.JTextField removeRecordId;
    // End of variables declaration//GEN-END:variables

    private void createTableModels() {
        bookModel = new DefaultTableModel(bookColumns, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bookTable.setModel(bookModel);

        borrowerModel = new DefaultTableModel(borrowerColumns, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        borrowerTable.setModel(borrowerModel);

        recordModel = new DefaultTableModel(recordColumns, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        recordTable.setModel(recordModel);
    }

    private void refreshBookTable() {
        bookModel.setRowCount(0);
        List<Book> books = businessLogicTier.getAllBooks();
        for (Book book : books) {
            Object[] bookData = {book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getAvailableQuantity()};
            bookModel.addRow(bookData);
        }
    }

    private void refreshBorrowerTable() {
        borrowerModel.setRowCount(0);
        List<Borrower> borrowers = businessLogicTier.getAllBorrowers();
        for (Borrower borrower : borrowers) {
            Object[] borrowerData = {borrower.getId(), borrower.getName(), borrower.getAddress(), borrower.getEmail(), borrower.getPhoneNumber()};
            borrowerModel.addRow(borrowerData);
        }
    }

    private void refreshRecordTable() {
        recordModel.setRowCount(0);
        List<Record> records = businessLogicTier.getAllRecords();
        for (Record record : records) {
            Object[] recordData = {record.getId(), record.getBorrowedBookName(), record.getBorrowerName()};
            recordModel.addRow(recordData);
        }
    }
}
