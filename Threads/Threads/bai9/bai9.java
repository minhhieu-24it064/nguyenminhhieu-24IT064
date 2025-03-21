package bai9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class bai9 extends Thread {
	    private String sourceFile;
	    private String destinationFile;

	    public bai9(String sourceFile, String destinationFile) {
	        this.sourceFile = sourceFile;
	        this.destinationFile = destinationFile;
	    }

	    @Override
	    public void run() {
	        int characterCount = 0;

	       
	        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
	            int ch;
	            while ((ch = reader.read()) != -1) {
	                characterCount++;
	            }
	            System.out.println("Số ký tự trong file " + sourceFile + ": " + characterCount);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return; 
	        }

	       
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
	            writer.write("Số ký tự trong file " + sourceFile + ": " + characterCount);
	            writer.newLine(); 
	            System.out.println("Đã ghi kết quả vào file " + destinationFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}



