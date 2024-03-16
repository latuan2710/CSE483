package application;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

public class CompressionCodec {

    public String compress(String data, String type) {

        switch (type.toLowerCase()) {
            case "gzip":
                return gzipCompress(data);

            case "bzip2":
                return bzip2Compress(data);

            default:
                return data;
        }
    }

    private String gzipCompress(String originalString) {
        try {
            byte[] data = originalString.getBytes("UTF-8");

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);

            gzipOutputStream.write(data);
            gzipOutputStream.close();

            System.out.println("Gzip compress successfully");

            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Gzip compress failed");

            return null;
        }
    }

    private String bzip2Compress(String originalString) {
        try {
            byte[] data = originalString.getBytes("UTF-8");

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BZip2CompressorOutputStream bzip2os = new BZip2CompressorOutputStream(byteArrayOutputStream);

            bzip2os.write(data);
            bzip2os.close();

            System.out.println("Bzip2 compress successfully");

            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();

            System.out.println("Bzip2 compress failed");

            return null;
        }
    }
}
