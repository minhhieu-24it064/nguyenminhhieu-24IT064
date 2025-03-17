package baitap;

import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhập nội dung (nhấn 'q' để kết thúc):");
            
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            String line;
            while (!(line = reader.readLine()).equals("q")) {
                writer.write(line);
                writer.newLine();
            }
            
            writer.close();
            reader.close();
            System.out.println("Dữ liệu đã được lưu vào file 'output.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
