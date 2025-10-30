package EmployeeRecordManagement;

public class Employee implements Cloneable {

    private String id;
    private String name;
    private String designation;
    private double salary;
    private Address address;

    public Employee(String id, String name, String designation, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void setSalary(double newSalary) {
        this.salary = newSalary;
    }

    public void setAddress(Address newAddress) {
        this.address = newAddress;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        try {
            return (Employee) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s\nName: %s\nDesignation: %s\nSalary: $%.2f\nAddress: %s\n",
                this.id, this.name, this.designation, this.salary, this.address.toString()
        );
    }
}
