package bai5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bai5 extends Thread {
    private String filename;
    private String message;

    public bai5(String filename, String message) {
        this.filename = filename;
        this.message = message;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
          
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            
            writer.write(timestamp + " - " + message);
            writer.newLine(); 
            System.out.println("Đã ghi log: " + timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

