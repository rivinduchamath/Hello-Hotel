package lk.sliit.employeeManagement.dto;

import java.sql.Date;
import java.util.List;


public class BarOrderDTO {

    private int id;
    private String customerId;
    private String user;
    private Object[] orderDetails;

    public BarOrderDTO(int id, String customerId, String user, Object[] orderDetails) {
        this.id = id;
        this.customerId = customerId;
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public BarOrderDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Object[] getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Object[] orderDetails) {
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
