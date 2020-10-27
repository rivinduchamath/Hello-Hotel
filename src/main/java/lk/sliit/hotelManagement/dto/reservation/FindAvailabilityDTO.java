package lk.sliit.hotelManagement.dto.reservation;

import java.sql.Date;

public class FindAvailabilityDTO {
    private Date checkIn;
    private Date checkOut;
    private String email;
    private String condition;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public FindAvailabilityDTO(Date checkIn, Date checkOut, String email, String condition) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.email = email;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "FindAvailabilityDTO{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", email='" + email + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
