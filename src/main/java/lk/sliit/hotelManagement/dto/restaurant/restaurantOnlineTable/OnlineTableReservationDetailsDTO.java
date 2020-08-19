package lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable;



public class OnlineTableReservationDetailsDTO {

    private String onlineTableReservation;
    private String tableId;
    private double quantity;
    private double unitePrice;

    public OnlineTableReservationDetailsDTO(String onlineTableReservation, String tableId, double quantity, double unitePrice) {
        this.onlineTableReservation = onlineTableReservation;
        this.tableId = tableId;
        this.quantity = quantity;
        this.unitePrice = unitePrice;
    }

    public OnlineTableReservationDetailsDTO() {
    }

    public String getOnlineTableReservation() {
        return onlineTableReservation;
    }

    public void setOnlineTableReservation(String onlineTableReservation) {
        this.onlineTableReservation = onlineTableReservation;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    @Override
    public String toString() {
        return "OnlineTableReservationDetailsDTO{" +
                "onlineTableReservation='" + onlineTableReservation + '\'' +
                ", tableId='" + tableId + '\'' +
                ", quantity=" + quantity +
                ", unitePrice=" + unitePrice +
                '}';
    }
}
