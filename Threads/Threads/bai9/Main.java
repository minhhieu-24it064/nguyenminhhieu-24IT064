package bai9;

public class Main {
	public static void main(String[] args) {
        String sourceFile = "mydoc.txt"; 
        String destinationFile = "yourdoc.txt"; 

        
        bai9 characterCountThread = new bai9(sourceFile, destinationFile);
        characterCountThread.start();

        
        try {
            characterCountThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hoàn tất đếm ký tự và ghi kết quả vào file.");
    }

}
