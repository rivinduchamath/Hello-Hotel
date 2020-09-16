package lk.sliit.hotelManagement.dto.beverage;

import java.util.Date;
import java.util.List;


public class BarOrderDTO {

    private int id;
    private int customerId;
    private int user;
    private List<BarOrderDetailDTO> orderDetails;
    private  String orderData;
    private Date date;

    public BarOrderDTO(int id, int customerId, int user, List<BarOrderDetailDTO> orderDetails) {
        this.id = id;
        this.customerId = customerId;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public BarOrderDTO(int id, int customerId, int user, List<BarOrderDetailDTO> orderDetails, String orderData) {
        this.id = id;
        this.customerId = customerId;
        this.user = user;
        this.orderDetails = orderDetails;
        this.orderData = orderData;
    }

    public BarOrderDTO(int id, int customerId, int user, List<BarOrderDetailDTO> orderDetails, String orderData, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.user = user;
        this.orderDetails = orderDetails;
        this.orderData = orderData;
        this.date = date;
    }

    public BarOrderDTO(int orderId) {
        this.id = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BarOrderDTO() {
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public BarOrderDTO(int orderId, int customerId, int user) {
        this.id = orderId;
        this.customerId = customerId;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public List<BarOrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<BarOrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "BarOrderDTO{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", user='" + user + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}//End Class
