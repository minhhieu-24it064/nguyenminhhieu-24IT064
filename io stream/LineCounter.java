package baitap;
import java.io.*;

public class LineCounter {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            int lineCount = 0;
            
            while ((reader.readLine()) != null) {
                lineCount++;
            }
            
            reader.close();
            System.out.println("Số dòng trong file: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}