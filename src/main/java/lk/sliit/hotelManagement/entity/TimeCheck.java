package lk.sliit.hotelManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TimeCheck {
@Id
    String id;
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
