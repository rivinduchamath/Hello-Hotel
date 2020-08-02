package lk.sliit.employeeManagement.dto.restaurant;

public class RestaurantTable {
    private String tableId;

    public RestaurantTable() {
    }

    public RestaurantTable(String tableId) {
        this.tableId = tableId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "RestaurantTable{" +
                "tableId='" + tableId + '\'' +
                '}';
    }
}
