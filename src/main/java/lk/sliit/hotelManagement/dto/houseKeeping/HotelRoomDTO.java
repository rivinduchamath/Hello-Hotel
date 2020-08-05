package lk.sliit.hotelManagement.dto.houseKeeping;

public class HotelRoomDTO {
    private String roomId;
    private String roomType;
    private String description;
    private double price;

    public HotelRoomDTO(String roomId, String roomType, String description, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.description = description;
        this.price = price;
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
