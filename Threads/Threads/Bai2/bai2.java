package Bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bai2 extends Thread {
    private String filename;
    private String content;

    public bai2(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    @Override
    public void run() {
        synchronized (bai2.class) { 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(content);
                writer.newLine(); 
                System.out.println("Đã ghi: " + content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
