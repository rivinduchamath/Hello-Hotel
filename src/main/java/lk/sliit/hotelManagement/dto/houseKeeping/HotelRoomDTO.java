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


    public HotelRoomDTO(String roomId, String roomType, String description, double price, String roomName, Date date, String status) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.description = description;
        this.price = price;
        this.roomName = roomName;
        this.date = date;
        this.status = status;

    }

    public HotelRoomDTO() {
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
