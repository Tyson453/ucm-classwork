
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final String invoiceFileName = "invoice.txt";

        // Make sure invoice file is empty first
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(invoiceFileName))) {
            writer.write("");
        } catch (IOException e) {
        }

        // array of orders
        Order[] orders = new Order[]{
            new Order("ORD101", "Alice", "Laptop", 1),
            new Order("ORD102", "Bob", "Smartphone", 2),
            new Order("ORD103", "Charlie", "Monitor", 1),
            new Order("ORD104", "Diana", "Keyboard", 3),
            new Order("ORD105", "Ethan", "Tablet", 1)
        };

        // create threads array from orders array
        Thread[] threads = new Thread[orders.length];
        for (int i = 0; i < orders.length; i++) {
            threads[i] = new Thread(new OrderProcessor(orders[i], invoiceFileName));
            // make sure each thread gets started
            threads[i].start();
        }

        // wait for each thread to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for orders to finish");;
            }
        }

        System.out.println("All orders have been processed. Invoice generated in " + invoiceFileName);
    }
}
