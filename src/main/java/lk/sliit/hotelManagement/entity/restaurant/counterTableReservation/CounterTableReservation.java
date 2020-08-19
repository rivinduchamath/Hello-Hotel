package lk.sliit.hotelManagement.entity.restaurant.counterTableReservation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CounterTableReservation {
    @Id
    private String counterTableReserveId;
   private Time startTime;
   private Time endTime;
   private int noOfTables;
   private Date date;

    @OneToMany(mappedBy = "counterTableReservation", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<CounterTableReservationDetails> orderDetails = new ArrayList<>();

    public CounterTableReservation(String counterTableReserveId, Time startTime, Time endTime, int noOfTables, Date date) {
        this.counterTableReserveId = counterTableReserveId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfTables = noOfTables;
        this.date = date;
    }

    public CounterTableReservation() {
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getNoOfTables() {
        return noOfTables;
    }

    public void setNoOfTables(int noOfTables) {
        this.noOfTables = noOfTables;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public List<CounterTableReservationDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<CounterTableReservationDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
