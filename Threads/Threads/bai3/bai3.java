package bai3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class bai3 extends Thread {
    private String sourceFile;
    private String destinationFile;

    public bai3(String sourceFile, String destinationFile) {
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Sao chép hoàn tất từ " + sourceFile + " sang " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
