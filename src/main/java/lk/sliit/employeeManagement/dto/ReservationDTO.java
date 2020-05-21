package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class ReservationDTO {


    private String reservationId ;
    private String title;
    private String description;
    private Date date;

    public ReservationDTO(String reservationId, String title, String description, Date date) {
        this.reservationId = reservationId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public ReservationDTO() {
    }

    public String getNoticeId() {
        return reservationId;
    }

    public void setNoticeId(String reservationId) {
        this.reservationId = reservationId;
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
        return "ReservationDTO{" +
                "reservationId='" + reservationId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End Class

