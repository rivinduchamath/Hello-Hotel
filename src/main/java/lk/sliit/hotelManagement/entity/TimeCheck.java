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
    Date timeOne;
    @DateTimeFormat(pattern="hh:mm:ss" )
    @Temporal(TemporalType.TIME)
    Date timeTwo;
    @Temporal(TemporalType.DATE)
    Date date;




    public TimeCheck() {
    }

    public TimeCheck(String id, Time timeOne, Time timeTwo,Date valueOf2) {
        this.id = id;
        this.timeOne = timeOne;
        this.timeTwo = timeTwo;
        date = valueOf2;
    }

    public Date getTimeSett2() {
        return timeTwo;
    }

    public void setTimeSett2(Date timeSett2) {
        this.timeTwo = timeSett2;
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
        return timeOne;
    }

    public void setTimeSett(Date timeSett) {
        this.timeOne = timeSett;
    }
}
