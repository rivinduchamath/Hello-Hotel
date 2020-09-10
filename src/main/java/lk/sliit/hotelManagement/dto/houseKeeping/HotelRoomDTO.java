package lk.sliit.hotelManagement.dto.houseKeeping;

import java.sql.Date;

public class HotelRoomDTO {
    private String roomId;
    private String roomType;
    private String description;
    private double price;
    private String roomName;
    private Date date;
    private String status;
    private String holder;



    public HotelRoomDTO() {
    }

    public HotelRoomDTO(String roomId) {
    }

    public HotelRoomDTO(String roomId, String roomName, String roomType, String description, String status, String holder, double price, Date date) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
        this.status = status;
        this.holder = holder;
        this.price = price;
        this.date = date;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomName() { return roomName; }

    public void setRoomName(String roomName) { this.roomName = roomName; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getHolder() { return holder;}

    public String getType() { return roomType; }




    @Override
    public String toString() {
        return "HotelRoomDTO{" +
                "roomId='" + roomId + '\'' +
                ", roomType='" + roomType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }



}
