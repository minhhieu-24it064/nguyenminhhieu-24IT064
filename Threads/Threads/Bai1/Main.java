package Bai1;

public class Main {
	 public static void main(String[] args) {
	        String filename = "path/to/your/mydoc.txt"; 
	        Bai1 fileReaderThread = new Bai1(filename);
	        fileReaderThread.start();
	        
	        try {
	            fileReaderThread.join(); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
