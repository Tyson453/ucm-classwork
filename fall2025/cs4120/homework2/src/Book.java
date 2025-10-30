
public class Book extends LibraryItem implements Borrowable {

    private String author;
    private int numPages;

    public Book(String itemId, String title, double borrowPricePerDay, String author, int numPages) {
        super(itemId, title, borrowPricePerDay);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public double calculateBorrowCost(int days) {
        return this.borrowPricePerDay * days;
    }

    @Override
    public void displayDetails() {
        System.out.println(String.format(
                "[%s] ID: %s | Title: %s | Author: %s | Pages: %d | $/day: %.2f",
                this.getClass().getName(),
                this.itemId,
                this.title,
                this.author,
                this.numPages,
                this.borrowPricePerDay
        ));
    }

}
