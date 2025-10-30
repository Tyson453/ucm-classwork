package EmployeeRecordManagement;

public class Address implements Cloneable {

    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        try {
            return (Address) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s, %s, %s, %s",
                this.street, this.city, this.state, this.zip
        );
    }
}
