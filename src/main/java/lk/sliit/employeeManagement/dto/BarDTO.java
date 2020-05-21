package lk.sliit.employeeManagement.dto;

import java.sql.Date;



public class BarDTO {

    private String barId ;
    private String text;
    private String description;
    private Date date;

    public BarDTO(String barId, String text, String description, Date date) {
        this.barId = barId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public BarDTO() {
    }

    public String getBanquetId() {
        return barId;
    }

    public void setBanquetId(String barId) {
        this.barId = barId;
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
