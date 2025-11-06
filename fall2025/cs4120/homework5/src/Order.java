
public class Order {

    public String orderId;
    public String customerName;
    public String productName;
    public int quantity;

    public Order(String orderId, String customerName, String productName, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "Order ID: %s | Customer: %s | Product: %s | Quantity: %d",
                this.orderId,
                this.customerName,
                this.productName,
                this.quantity
        );
    }
}
