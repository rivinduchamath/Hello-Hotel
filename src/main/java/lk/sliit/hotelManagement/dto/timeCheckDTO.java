package lk.sliit.hotelManagement.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

public class timeCheckDTO {
    String id;
    String timeSett;
    @Temporal(TemporalType.TIME)
    Date date;

    public timeCheckDTO(String id, String timeSett) {
        this.id = id;
        this.timeSett = timeSett;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public timeCheckDTO() {
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


    @Override
    public String toString() {
        return "timeCheck{" +
                "id='" + id + '\'' +
                ", timeSett='" + timeSett + '\'' +
                '}';
    }
}
