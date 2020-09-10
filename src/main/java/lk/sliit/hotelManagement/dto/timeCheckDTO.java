package lk.sliit.hotelManagement.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


public class timeCheckDTO {
    String id;
    String timeSett;
    String timeSett2;
    String dateSett;
    @Temporal(TemporalType.TIME)
    Date tdate;
    @Temporal(TemporalType.TIME)
    Date tdate2;
    @Temporal(TemporalType.DATE)
    Date date;

    public timeCheckDTO(String id, String timeSett2,String timeSett, String dateSett) {
        this.id = id;
        this.timeSett = timeSett;
        this.timeSett2 = timeSett2;
        this.dateSett = dateSett;
    }

    public timeCheckDTO(String id,  Date tdate, Date tdate2, Date date) {
        this.id = id;
        this.tdate = tdate;
        this.tdate2 = tdate2;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public timeCheckDTO() {
    }

    public String getTimeSett2() {
        return timeSett2;
    }

    public void setTimeSett2(String timeSett2) {
        this.timeSett2 = timeSett2;
    }

    public String getDateSett() {
        return dateSett;
    }

    public void setDateSett(String dateSett) {
        this.dateSett = dateSett;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTimeSett() {
        return timeSett;
    }

    public void setTimeSett(String timeSett) {
        this.timeSett = timeSett;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTdate2() {
        return tdate2;
    }

    public void setTdate2(Date tdate2) {
        this.tdate2 = tdate2;
    }

    @Override
    public String toString() {
        return "timeCheckDTO{" +
                "id='" + id + '\'' +
                ", timeSett='" + timeSett + '\'' +
                ", timeSett2='" + timeSett2 + '\'' +
                ", dateSett='" + dateSett + '\'' +
                '}';
    }
}
