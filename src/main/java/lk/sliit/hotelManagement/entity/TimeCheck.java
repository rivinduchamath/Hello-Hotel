package lk.sliit.hotelManagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class TimeCheck {
    @Id
    String id;
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    Date timeSett;

    public TimeCheck(String id, Date timeSett) {
        this.id = id;
        this.timeSett = timeSett;
    }

    public TimeCheck() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimeSett() {
        return timeSett;
    }

    public void setTimeSett(Date timeSett) {
        this.timeSett = timeSett;
    }
}
