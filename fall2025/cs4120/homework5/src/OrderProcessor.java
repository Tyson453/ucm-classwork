
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderProcessor implements Runnable {

    private static final Object fileLock = new Object();

    private final Order order;
    private final String invoiceFileName;

    public OrderProcessor(Order order, String invoiceFileName) {
        this.order = order;
        this.invoiceFileName = invoiceFileName;
    }

    @Override
    public void run() {
        try {
            // print processing message
            System.out.println(
                    String.format(
                            "Processing Order %s for %s",
                            this.order.orderId,
                            this.order.customerName
                    )
            );

            // simulate delay
            Thread.sleep(2000);

            synchronized (fileLock) {
                // write order to invoice
                try (BufferedWriter invoiceWriter = new BufferedWriter(new FileWriter(this.invoiceFileName, true))) {
                    invoiceWriter.append(this.order.toString());
                    invoiceWriter.newLine();

                    System.out.println("Completed Order " + this.order.orderId);
                } catch (IOException e) {
                    System.out.println("Failed to write order summary to invoice file: " + this.invoiceFileName);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("Order %s failed to be processed due to an interruption", this.order.orderId));
        }
    }
}
