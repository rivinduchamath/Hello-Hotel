package lk.sliit.employeeManagement.dto.reservation;

public class CustomerDTO {
    private String customerId;
    private String email;
    private String name;
    private String address;
    private int contactNumber;

    public CustomerDTO(String customerId, String email, String name, String address, int contactNumber) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public CustomerDTO() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
