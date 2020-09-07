package lk.sliit.hotelManagement.dto.restaurant;

public class RestaurantTableDTO {
    private String tableId;
    private String type;
    private double unitPrice;

    public RestaurantTableDTO() {
    }

    public RestaurantTableDTO(String tableId, String type, double unitPrice) {
        this.tableId = tableId;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    public String getTableId() {
        return tableId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "RestaurantTableDTO{" +
                "tableId='" + tableId + '\'' +
                ", type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
