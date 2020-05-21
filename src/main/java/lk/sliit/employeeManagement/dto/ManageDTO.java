package lk.sliit.employeeManagement.dto;

import java.sql.Date;


public class ManageDTO  {

    private String manageID ;
    private String title;
    private String description;
    private Date date;

    public ManageDTO(String manageID, String title, String description, Date date) {
        this.manageID = manageID;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public ManageDTO() {
    }

    public String getNoticeId() {
        return manageID;
    }

    public void setNoticeId(String manageID) {
        this.manageID = manageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "ManageDTO{" +
                "manageID='" + manageID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End Class
