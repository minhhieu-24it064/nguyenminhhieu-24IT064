package baitap;
  

import java.util.LinkedList;
import java.util.LinkedList;

class Table {
    private final int MAX_CAPACITY = 5; 
    private final LinkedList<String> dishes = new LinkedList<>();
        public synchronized void cook(String dish) throws InterruptedException {
            while (dishes.size() == MAX_CAPACITY) {
                System.out.println("Bàn đầy, đầu bếp đợi...");
                wait();
            }
            dishes.add(dish);
            System.out.println("Đầu bếp nấu: " + dish);
            notify();
        }

     
        public synchronized void eat() throws InterruptedException {
            while (dishes.isEmpty()) {
                System.out.println("Bàn trống, khách đợi...");
                wait();
            }
            String dish = dishes.removeFirst();
            System.out.println("Khách ăn: " + dish);
            notify();
    }
    }
 
class Chef extends Thread {
    private final Table table;
    private int dishNumber = 1;

    public Chef(Table table) {
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                table.cook("Món ăn " + dishNumber++);
                Thread.sleep(2000); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Customer extends Thread {
    private final Table table;

    public Customer(Table table) {
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                table.eat();
                Thread.sleep(3000); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
}
}
}
public class Restaurant {
    public static void main(String[] args) {
        Table table = new Table();
        Chef chef = new Chef(table);
        Customer customer = new Customer(table);

        chef.start();
        customer.start();
    }
}
