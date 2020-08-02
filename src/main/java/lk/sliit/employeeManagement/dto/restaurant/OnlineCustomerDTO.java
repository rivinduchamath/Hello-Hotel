package lk.sliit.employeeManagement.dto.restaurant;

public class OnlineCustomerDTO {
    private String onlineCustomerId;
    private  String name;
    private  String userName;
    private  String address;
    private String email;
    private String password;

    public OnlineCustomerDTO() {
    }

    public OnlineCustomerDTO(String onlineCustomerId, String name, String userName, String address, String email, String password) {
        this.onlineCustomerId = onlineCustomerId;
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getOnlineCustomerId() {
        return onlineCustomerId;
    }

    public void setOnlineCustomerId(String onlineCustomerId) {
        this.onlineCustomerId = onlineCustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "OnlineCustomerDTO{" +
                "onlineCustomerId='" + onlineCustomerId + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
