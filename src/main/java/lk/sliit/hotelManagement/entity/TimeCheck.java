package lk.sliit.hotelManagement.entity;

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
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    Date timeSett2;
    @Temporal(TemporalType.DATE)
    Date date;


    public TimeCheck(String id, Date timeSett) {
        this.id = id;
        this.timeSett = timeSett;
    }

    public TimeCheck() {
    }

    public TimeCheck(String id, Time valueOf, Time valueOf1,Date valueOf2) {
        this.id = id;
        this.timeSett = valueOf;
        timeSett2 = valueOf1;
        date = valueOf2;
    }

    public Date getTimeSett2() {
        return timeSett2;
    }

    public void setTimeSett2(Date timeSett2) {
        this.timeSett2 = timeSett2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
