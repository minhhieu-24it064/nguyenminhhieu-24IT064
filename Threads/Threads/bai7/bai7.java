package bai7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class bai7  extends Thread {
    private String filename;

    public bai7(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Nhập dữ liệu (gõ 'exit' để thoát):");
            String input;
            while (true) {
                input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break; 
                }
                writer.write(input);
                writer.newLine(); 
                System.out.println("Đã ghi: " + input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

