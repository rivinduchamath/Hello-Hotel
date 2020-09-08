package lk.sliit.hotelManagement.entity.houseKeeping;


import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Collection;

@Entity
public class HotelRoom {
    @Id
    private String roomId;
    private String roomName;
    private String roomType;//A/c Or Not
    @Column(length = 1000)
    private String description;
    private String status;//cleaned Or Not
    private String holder;
    private double price;
    private Date date;
    @OneToMany(mappedBy = "roomId")
    private Collection<ReservationDetails> reservationRoom;
    @OneToMany(mappedBy = "roomId")
    private Collection<RoomService> roomServices;
    @OneToMany(mappedBy = "roomId")
    private Collection<RoomIncome> roomIncome;

    public HotelRoom(String roomId, String roomType, String description, String status, String holder, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.description = description;
        this.status = status;
        this.holder = holder;
        this.price = price;
    }

    public HotelRoom(String roomId, String roomName, String roomType, String description, String status, String holder,
                     double price, Date date) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
        this.status = status;
        this.holder = holder;
        this.price = price;
        this.date = date;
    }

    public HotelRoom() {
    }
    

    public HotelRoom(String roomId, String roomName, String roomType, String description, String status, Date date) {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<ReservationDetails> getReservationRoom() {
        return reservationRoom;
    }

    public void setReservationRoom(Collection<ReservationDetails> reservationRoom) {
        this.reservationRoom = reservationRoom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
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


}
