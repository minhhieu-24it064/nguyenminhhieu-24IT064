package baitap;

class CountdownThread extends Thread {
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Countdown {
    public static void main(String[] args) {
        CountdownThread thread = new CountdownThread();
        thread.start();
    }
}
