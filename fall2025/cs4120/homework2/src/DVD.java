
public class DVD extends LibraryItem implements Borrowable {

    private int durationMinutes;
    private String ageRating;

    public DVD(String itemId, String title, double borrowPricePerDay, int durationMinutes, String ageRating) {
        super(itemId, title, borrowPricePerDay);
        this.durationMinutes = durationMinutes;
        this.ageRating = ageRating;
    }

    @Override
    public double calculateBorrowCost(int days) {
        return this.borrowPricePerDay * days;
    }

    @Override
    public void displayDetails() {
        System.out.println(String.format(
                "[%s] ID: %s | Title: %s | Duration: %d min | Rating: %s | $/day: %.2f",
                this.getClass().getName(),
                this.itemId,
                this.title,
                this.durationMinutes,
                this.ageRating,
                this.borrowPricePerDay
        ));
    }

}
