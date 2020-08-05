package lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable;

import java.sql.Date;
import java.sql.Time;

public class CounterTableReservationDTO {
    private String counterTableReserveId;
    private Time startTime;
    private Time endTime;
    private int noOfTables;
    private Date date;

    public CounterTableReservationDTO(String counterTableReserveId, Time startTime, Time endTime, int noOfTables, Date date) {
        this.counterTableReserveId = counterTableReserveId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfTables = noOfTables;
        this.date = date;
    }

    public CounterTableReservationDTO() {
    }

    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
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

    @Override
    public String toString() {
        return "CounterTableReservationDTO{" +
                "counterTableReserveId='" + counterTableReserveId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", noOfTables=" + noOfTables +
                ", date=" + date +
                '}';
    }
}
