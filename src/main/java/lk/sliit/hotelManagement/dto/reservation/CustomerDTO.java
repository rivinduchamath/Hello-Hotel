package lk.sliit.hotelManagement.dto.reservation;

public class CustomerDTO {
    private int customerId;
    private String email;
    private String name;
    private String address;
    private String contactNumber;
    private String userName;
    private String password;
    private int age;
    private String state;

    public CustomerDTO(int customerId, String email, String name, String address, String contactNumber) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public CustomerDTO(int customerId, String email, String name,
                       String address, String contactNumber, String userName, String password, int age) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public CustomerDTO(int customerId, String email, String name, String address, String contactNumber, String userName, String password) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.userName = userName;
        this.password = password;
    }

    public CustomerDTO(int customerId, String email, String name, String address, String contactNumber, String state) {
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.state = state;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String name, String password) {
        this.customerId = customerId;
        this.name = name;
        this.password = password;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CustomerDTO(int customerId) {
        this.customerId=customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                '}';
    }
}
