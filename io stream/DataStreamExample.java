package baitap;
import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("numbers.dat"));
            int[] numbers = {10, 20, 30, 40, 50};
            for (int number : numbers) {
                dataOutputStream.writeInt(number);
            }
            dataOutputStream.close();
            
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("numbers.dat"));
            System.out.println("Các số nguyên trong file:");
            while (dataInputStream.available() > 0) {
                int number = dataInputStream.readInt();
                System.out.println(number);
            }
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
