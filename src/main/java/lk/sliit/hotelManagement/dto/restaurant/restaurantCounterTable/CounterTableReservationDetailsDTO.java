package lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable;



public class CounterTableReservationDetailsDTO {
    private int counterTableReservation;
    private int tableId;
    private double unitePrice;
    private double quantity;

    public CounterTableReservationDetailsDTO(int counterTableReservation, int tableId, double unitePrice, double quantity) {
        this.counterTableReservation = counterTableReservation;
        this.tableId = tableId;
        this.unitePrice = unitePrice;
        this.quantity = quantity;
    }

    public CounterTableReservationDetailsDTO() {
    }

    public int getCounterTableReservation() {
        return counterTableReservation;
    }

    public void setCounterTableReservation(int counterTableReservation) {
        this.counterTableReservation = counterTableReservation;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CounterTableReservationDetailsDTO{" +
                "counterTableReservation='" + counterTableReservation + '\'' +
                ", tableId='" + tableId + '\'' +
                ", unitePrice=" + unitePrice +
                ", quantity=" + quantity +
                '}';
    }
}
