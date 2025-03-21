package bai7;

public class Main {
	public static void main(String[] args) {
        String filename = "thongtin.txt"; 

        
        bai7 userInputThread = new bai7(filename);
        userInputThread.start();

        
        try {
            userInputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hoàn tất ghi dữ liệu vào file.");
    }

}
