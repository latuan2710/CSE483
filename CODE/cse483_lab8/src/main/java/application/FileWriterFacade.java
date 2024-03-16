package application;

public class FileWriterFacade {
	private CompressionCodec compressionCodec;
	private EncryptionCodec encryptionCodec;
	private FileWriterFactory fileWriter;

	public FileWriterFacade() {
		this.compressionCodec = new CompressionCodec();
		this.encryptionCodec = new EncryptionCodec();
		this.fileWriter = new ConcreteFileWriters();
	}

	public void writeData(String data, String fileType, String encryptionType, String compressType) {
		data = compressionCodec.compress(data, compressType);
		data = encryptionCodec.encrypt(data, encryptionType);
		fileWriter.writeFile(data, fileType);
		System.out.println("\n");
	}
}