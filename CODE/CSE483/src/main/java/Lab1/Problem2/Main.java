package Lab1.Problem2;

public class Main {
	public static void main(String[] args) {
		String text = "This is a string";

		FileWriterFacade facade = new FileWriterFacade();

		facade.writeData(text, "csv", "aes", "gzip");
		facade.writeData(text, "json", "des", "bzip2");
		facade.writeData(text, "xml", "aes", "gzip");
	}
}
