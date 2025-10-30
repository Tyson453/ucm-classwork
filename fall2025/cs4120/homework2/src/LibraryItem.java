
public abstract class LibraryItem {

    protected String itemId;
    protected String title;
    protected double borrowPricePerDay;
    protected boolean isAvailable;

    public LibraryItem(String itemId, String title, double borrowPricePerDay) {
        this.itemId = itemId;
        this.title = title;
        this.borrowPricePerDay = borrowPricePerDay;
        this.isAvailable = true;
    }

    public String getItemId() {
        return this.itemId;
    }

    public double getBorrowPricePerDay() {
        return this.borrowPricePerDay;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public abstract void displayDetails();
}
