package lk.sliit.employeeManagement.dto.restaurant;


public class RestaurantBillDTO {
    private String billId;
    private String type;
    private double total;
    private double discount;
    private String restaurantOrder;
    private String onlineOrder;
    private String counterTableReserveId;
    private String onlineTableReservation;

    public RestaurantBillDTO(String billId, String type, double total, double discount,
                             String restaurantOrder, String onlineOrder,
                             String counterTableReserveId, String onlineTableReservation) {
        this.billId = billId;
        this.type = type;
        this.total = total;
        this.discount = discount;
        this.restaurantOrder = restaurantOrder;
        this.onlineOrder = onlineOrder;
        this.counterTableReserveId = counterTableReserveId;
        this.onlineTableReservation = onlineTableReservation;
    }

    public RestaurantBillDTO() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getRestaurantOrder() {
        return restaurantOrder;
    }

    public void setRestaurantOrder(String restaurantOrder) {
        this.restaurantOrder = restaurantOrder;
    }

    public String getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(String onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public String getOnlineTableReservation() {
        return onlineTableReservation;
    }

    public void setOnlineTableReservation(String onlineTableReservation) {
        this.onlineTableReservation = onlineTableReservation;
    }

    @Override
    public String toString() {
        return "RestaurantBillDTO{" +
                "billId='" + billId + '\'' +
                ", type='" + type + '\'' +
                ", total=" + total +
                ", discount=" + discount +
                ", restaurantOrder='" + restaurantOrder + '\'' +
                ", onlineOrder='" + onlineOrder + '\'' +
                ", counterTableReserveId='" + counterTableReserveId + '\'' +
                ", onlineTableReservation='" + onlineTableReservation + '\'' +
                '}';
    }
}
