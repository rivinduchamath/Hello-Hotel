package lk.sliit.employeeManagement.dto;


import java.sql.Date;


public class KitchenDTO {

    private String kitchenId ;
    private String text;
    private String description;
    private Date date;

    public KitchenDTO(String kitchenId, String text, String description, Date date) {
        this.kitchenId = kitchenId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public KitchenDTO() {
    }

    public String getBanquetId() {
        return kitchenId;
    }

    public void setBanquetId(String kitchenId) {
        this.kitchenId = kitchenId;
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
}//End Class

