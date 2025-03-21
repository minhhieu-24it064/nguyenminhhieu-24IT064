package bai5;

public class Main {
	public static void main(String[] args) {
        String filename = "log.txt"; 

     
        bai5 logThread1 = new bai5(filename, "Thông điệp log từ Thread 1");
        bai5 logThread2 = new bai5(filename, "Thông điệp log từ Thread 2");

        logThread1.start();
        logThread2.start();

        
        try {
            logThread1.join();
            logThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hoàn tất ghi log.");
    }

}
