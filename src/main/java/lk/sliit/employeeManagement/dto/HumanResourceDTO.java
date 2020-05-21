package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class HumanResourceDTO  {

    private String houseID ;
    private String text;
    private String description;
    private Date date;

    public HumanResourceDTO(String houseID, String text, String description, Date date) {
        this.houseID = houseID;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public HumanResourceDTO() {
    }

    public String getBanquetId() {
        return houseID;
    }

    public void setBanquetId(String houseID) {
        this.houseID = houseID;
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
        return "HumanResourceDTO{" +
                "houseID='" + houseID + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End Class
