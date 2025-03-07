package baitap;

public class main {
	    public static void main(String[] args) {
	        Thread evenThread = new Thread(new EvenPrinter(), "Even");
	        Thread oddThread = new Thread(new OddPrinter(), "Odd");

	        evenThread.start();
	        oddThread.start();
	    }
	}

	class EvenPrinter implements Runnable { 
	    @Override
	    public void run() {
	        for (int i = 2; i <= 10; i += 2) {
	            System.out.println(Thread.currentThread().getName() + ": " + i);
	           
	        }
	    }
	}
 
	class OddPrinter implements Runnable {
	    @Override
	    public void run() {
	        for (int i = 1; i <= 10; i += 2) {
	            System.out.println(Thread.currentThread().getName() + ": " + i);
	           
	        }
	    }
	}

