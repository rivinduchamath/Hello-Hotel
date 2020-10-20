package lk.sliit.hotelManagement.dto.houseKeeping;


import java.sql.Date;

public class LaundryDTO {

    private int laundryId;
    private int customerId;
    private int orderHolder;
    private double  pieces;
    private Date expectedDate;
    private Date date;
    private String state;

    public LaundryDTO() {}

    public LaundryDTO(int laundryId, int customerId, int orderHolder, double pieces, Date expectedDate, Date date) {
        this.laundryId = laundryId;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
        this.pieces = pieces;
        this.expectedDate = expectedDate;
        this.date = date;
    }

    public LaundryDTO(int laundryId, int customerId, int orderHolder, double pieces, Date expectedDate, Date date, String state) {
        this.laundryId = laundryId;
        this.customerId = customerId;
        this.orderHolder = orderHolder;
        this.pieces = pieces;
        this.expectedDate = expectedDate;
        this.date = date;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LaundryDTO(int laundryId) {
        this.laundryId = laundryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLaundryId() {
        return laundryId;
    }

    public void setLaundryId(int laundryId) {
        this.laundryId = laundryId;
    }

    @Override
    public String toString() {
        return "LaundryDTO{" +
                "laundryId=" + laundryId +
                ", customerId=" + customerId +
                ", orderHolder=" + orderHolder +
                ", pieces=" + pieces +
                ", expectedDate=" + expectedDate +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }
}
