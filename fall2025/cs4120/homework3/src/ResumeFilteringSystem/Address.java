package ResumeFilteringSystem;

import java.util.Objects;

public class Address {

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
    public String toString() {
        return String.format(
                "%s, %s, %s, %s",
                this.street, this.city, this.state, this.zip
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address otherAddress = (Address) other;
        return Objects.equals(this.street, otherAddress.street)
                && Objects.equals(this.city, otherAddress.city)
                && Objects.equals(this.state, otherAddress.state)
                && Objects.equals(this.zip, otherAddress.zip);
    }
}
