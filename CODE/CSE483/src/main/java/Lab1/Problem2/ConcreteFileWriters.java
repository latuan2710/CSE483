package Lab1.Problem2;

import java.io.FileWriter;
import java.io.IOException;

public class ConcreteFileWriters implements FileWriterFactory {

    @Override
    public void writeFile(String data, String fileType) {
        switch (fileType.toLowerCase()) {
            case "csv":
                writeCSVFile(data);
                break;
            case "json":
                writeJSONFile(data);
                break;
            case "xml":
                writeXMLFile(data);
                break;

            default:
                break;
        }
    }

    private void writeCSVFile(String data) {
        String filePath = "output.csv";
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            fileWriter.write(data);
            fileWriter.close();

            System.out.println("CSV file written successfully: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write file CSV successfully");
    }

    private void writeJSONFile(String data) {
        String filePath = "output.json";
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            fileWriter.write(data);
            fileWriter.close();

            System.out.println("JSON file written successfully: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write file JSON successfully");
    }

    private void writeXMLFile(String data) {
        String filePath = "output.xml";
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            fileWriter.write(data);
            fileWriter.close();

            System.out.println("XML file written successfully: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Write file XML successfully");
    }

}
