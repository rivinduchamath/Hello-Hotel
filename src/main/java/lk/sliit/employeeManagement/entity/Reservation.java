package lk.sliit.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Reservation implements SuperEntity {

    @Id
    private String reservationId ;
    private String title;
    @Column(length = 1000)
    private String description;
    private Date date;

    public Reservation(String reservationId, String title, String description, Date date) {
        this.reservationId = reservationId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Reservation() {
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

}//End Class

