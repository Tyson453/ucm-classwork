
public class Magazine extends LibraryItem implements Borrowable {

    private String issue;
    private String publisher;

    public Magazine(String itemId, String title, double borrowPricePerDay, String issue, String publisher) {
        super(itemId, title, borrowPricePerDay);
        this.issue = issue;
        this.publisher = publisher;
    }

    @Override
    public double calculateBorrowCost(int days) {
        return this.borrowPricePerDay * days;
    }

    @Override
    public void displayDetails() {
        System.out.println(String.format(
                "[%s] ID: %s | Title: %s | Issue: %s | Publisher: %s | $/day: %.2f",
                this.getClass().getName(),
                this.itemId,
                this.title,
                this.issue,
                this.publisher,
                this.borrowPricePerDay
        ));
    }
}
