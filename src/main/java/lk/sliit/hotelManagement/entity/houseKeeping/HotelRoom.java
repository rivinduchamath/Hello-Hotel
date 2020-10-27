package lk.sliit.hotelManagement.entity.houseKeeping;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class HotelRoom {
    @Id
    private int roomId;
    private String roomName;
    private String roomType;//A/C Or Not
    @Column(length = 1000)
    private String description;
    private String status;//cleaned Or Not
    private int holder;
    private double price;
    private Date date;
    @OneToMany(mappedBy = "roomId",cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private Collection<ReservationDetails> reservationRoom = new ArrayList<>();;
    @OneToMany(mappedBy = "roomId",cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private Collection<RoomService> roomServices= new ArrayList<>();;
    @OneToMany(mappedBy = "roomId" ,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private Collection<RoomIncome> roomIncome  = new ArrayList<>();;

    public HotelRoom(int roomId, String roomName, String roomType, String description,
                     String status, int holder, double price, Date date,
                     Collection<ReservationDetails> reservationRoom, Collection<RoomService> roomServices, Collection<RoomIncome> roomIncome) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
        this.status = status;
        this.holder = holder;
        this.price = price;
        this.date = date;
        this.reservationRoom = reservationRoom;
        this.roomServices = roomServices;
        this.roomIncome = roomIncome;
    }

    public HotelRoom(int roomId, String roomName, String roomType,
                     String description, String status, int holder,
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHolder() {
        return holder;
    }

    public void setHolder(int holder) {
        this.holder = holder;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
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
