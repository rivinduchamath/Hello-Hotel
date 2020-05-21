package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class InventoryDTO{

    private String inventoryId ;
    private String text;
    private String description;
    private Date date;

    public InventoryDTO(String inventoryId, String text, String description, Date date) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public InventoryDTO() {
    }

    public String getBanquetId() {
        return inventoryId;
    }

    public void setBanquetId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "inventoryId='" + inventoryId + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End Class

