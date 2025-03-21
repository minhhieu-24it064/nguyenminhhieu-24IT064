package Bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai1 extends Thread {
    private String filename;

    public Bai1(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
