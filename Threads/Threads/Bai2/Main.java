package Bai2;

public class Main {
	public static void main(String[] args) {
        String filename = "mydoc.txt"; 

        
        bai2 thread1 = new bai2(filename, "Chuỗi từ Thread 1");
        bai2 thread2 = new bai2(filename, "Chuỗi từ Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hoàn thành ghi vào file.");
    }

}
