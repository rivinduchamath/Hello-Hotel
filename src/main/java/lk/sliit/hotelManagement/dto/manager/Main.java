package lk.sliit.hotelManagement.dto.manager;

public class Main {
    public static void main(String[] args) {
        Customer cus = new Customer("Name","Adde");
        String s = cus.getName();
        System.out.println(s);
    }
}
class Customer{
Customer(){

}
String name;
String address;
    public Customer(String name, String adde) {
    this.name = name;
    address = adde;
    }

    public String getName() {
        return name;
    }


}