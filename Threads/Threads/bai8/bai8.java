package bai8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class bai8 {
	  static BlockingQueue<String> queue = new LinkedBlockingQueue<>();

	    static class Reader extends Thread {
	        private String source;

	        public Reader(String source) {
	            this.source = source;
	        }

	        @Override
	        public void run() {
	            try (BufferedReader br = new BufferedReader(new FileReader(source))) {
	                String line;
	                while ((line = br.readLine()) != null) {
	                    queue.put(line);
	                }
	                queue.put("END");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    static class Writer extends Thread {
	        private String destination;

	        public Writer(String destination) {
	            this.destination = destination;
	        }

	        @Override
	        public void run() {
	            try (FileWriter fw = new FileWriter(destination)) {
	                while (true) {
	                    String line = queue.take();
	                    if (line.equals("END")) break;
	                    fw.write(line + "\n");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Reader reader = new Reader("source.txt");
	        Writer writer = new Writer("destination.txt");
	        reader.start();
	        writer.start();
	    }


}
