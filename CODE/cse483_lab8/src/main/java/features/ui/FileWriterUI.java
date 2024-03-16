package features.ui;

import javax.swing.*;

import application.FileWriterFacade;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileWriterUI extends JFrame {
    private FileWriterFacade facade;
    private JTextField textField;
    private JComboBox<String> compressionComboBox;
    private JComboBox<String> encryptionComboBox;
    private JComboBox<String> fileTypeComboBox;

    public FileWriterUI() {
        super("File Writer UI");
        this.facade = new FileWriterFacade();
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        JLabel textLabel = new JLabel("Enter text:");
        textField = new JTextField();
        panel.add(textLabel);
        panel.add(textField);

        JLabel compressionLabel = new JLabel("Compression:");
        compressionComboBox = new JComboBox<>(new String[] { "Gzip", "Bzip2" });
        panel.add(compressionLabel);
        panel.add(compressionComboBox);

        JLabel encryptionLabel = new JLabel("Encryption:");
        encryptionComboBox = new JComboBox<>(new String[] { "AES", "DES" });
        panel.add(encryptionLabel);
        panel.add(encryptionComboBox);

        JLabel fileTypeLabel = new JLabel("File Type:");
        fileTypeComboBox = new JComboBox<>(new String[] { "CSV", "JSON", "XML" });
        panel.add(fileTypeLabel);
        panel.add(fileTypeComboBox);

        JButton writeButton = new JButton("Write File");
        panel.add(writeButton);

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String compression = (String) compressionComboBox.getSelectedItem();
                String encryption = (String) encryptionComboBox.getSelectedItem();
                String fileType = (String) fileTypeComboBox.getSelectedItem();

                facade.writeData(text, fileType.toLowerCase(), encryption.toLowerCase(), compression.toLowerCase());
            }
        });

        add(panel);
    }
}
