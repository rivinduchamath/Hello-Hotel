package lk.sliit.hotelManagement.dto.reservation;

import java.sql.Date;

public class FindAvailabilityDTO {
    private Date checkIn;
    private Date checkOut;

    public FindAvailabilityDTO() {
    }

    public FindAvailabilityDTO(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "FindAvailabilityDTO{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
