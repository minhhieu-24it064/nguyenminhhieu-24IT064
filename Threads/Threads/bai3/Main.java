package bai3;

public class Main {
	 public static void main(String[] args) {
	        String sourceFile = "mydoc.txt"; 
	        String destinationFile = "yourdoc.txt"; 

	        
	        bai3 fileCopyThread = new bai3(sourceFile, destinationFile);
	        fileCopyThread.start();
	        
	        try {
	            fileCopyThread.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Chương trình hoàn tất.");
	    }

}
