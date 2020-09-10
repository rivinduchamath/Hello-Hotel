package lk.sliit.hotelManagement.dto.banquet;

import lk.sliit.hotelManagement.entity.kitchen.Menu;

import java.sql.Date;

public class BanquetAddDTO {
    private String orderId;
    private String customerId;
    private String email;
    private String name;
    private String address;
    private int contactNumber;
    private Date date;
    private String hallId;
    private String orderState;
    private int noOfPlates;
    private String submittedBy;
    private String menuId;
    private String banquetBillId;
    private double advanceFee;
    private double foodPrice;
    private double otherPrice;
    private double total;



    public BanquetAddDTO(String orderId, String customerId, String email, String name, String address, int contactNumber, Date date, String hallId, String orderState, int noOfPlates, String submittedBy, String menuId, String banquetBillId, double advanceFee, double foodPrice, double otherPrice, double total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.date = date;
        this.hallId = hallId;
        this.orderState = orderState;
        this.noOfPlates = noOfPlates;
        this.submittedBy = submittedBy;
        this.menuId = menuId;
        this.banquetBillId = banquetBillId;
        this.advanceFee = advanceFee;
        this.foodPrice = foodPrice;
        this.otherPrice = otherPrice;
        this.total = total;
    }

    public BanquetAddDTO() {

    }

    public BanquetAddDTO(String orderId, String name, String address, Date date, String hallId, int noOfPlates, String menuId, double advancePayment, String billId) {
        this.orderId = orderId;
        this.name = name;
        this.address = address;
        this.date = date;
        this.hallId = hallId;
        this.noOfPlates = noOfPlates;
        this.menuId = menuId;
        this.advanceFee = advancePayment;
        this.banquetBillId = billId;
    }

    public BanquetAddDTO(String orderId, String name, int contactNumber, Date date, String hallId, int noOfPlates, double advancePayment, String orderState) {
        this.orderId = orderId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.date = date;
        this.hallId = hallId;
        this.noOfPlates = noOfPlates;
        this.advanceFee = advancePayment;
        this.orderState= orderState;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getNoOfPlates() {
        return noOfPlates;
    }

    public void setNoOfPlates(int noOfPlates) {
        this.noOfPlates = noOfPlates;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getBanquetBillId() {
        return banquetBillId;
    }

    public void setBanquetBillId(String banquetBillId) {
        this.banquetBillId = banquetBillId;
    }

    public double getAdvanceFee() {
        return advanceFee;
    }

    public void setAdvanceFee(double advanceFee) {
        this.advanceFee = advanceFee;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BanquetAddDTO{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber=" + contactNumber +
                ", date=" + date +
                ", hallId='" + hallId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", noOfPlates=" + noOfPlates +
                ", submittedBy='" + submittedBy + '\'' +
                ", menuId='" + menuId + '\'' +
                ", banquetBillId='" + banquetBillId + '\'' +
                ", advanceFee=" + advanceFee +
                ", foodPrice=" + foodPrice +
                ", otherPrice=" + otherPrice +
                ", total=" + total +
                '}';
    }
}

