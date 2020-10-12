package lk.sliit.hotelManagement.dto.manager;

public class MailDTO {
    String name;
    String email;
    String message;
    String customerName;
    String customerAddress;


    public MailDTO(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public MailDTO(String name, String email, String message,
                   String customerName, String customerAddress) {
        this.name = name;
        this.email = email;
        this.message = message;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public MailDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
