package lk.sliit.employeeManagement.entity.houseKeeping;


import lk.sliit.employeeManagement.entity.reservation.ReservationDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class HotelRoom {
    @Id
    private String roomId;
    private String roomType;
    private String description;
    private double price;
    @OneToMany(mappedBy = "roomId")
    private Collection<ReservationDetails> reservationRoom;
    @OneToMany(mappedBy = "roomId")
    private Collection<RoomService> roomServices;


    public HotelRoom(String roomId, String roomType, String description, double price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.description = description;
        this.price = price;
    }

    public HotelRoom() {
    }

    public Collection<ReservationDetails> getReservationRoom() {
        return reservationRoom;
    }

    public void setReservationRoom(Collection<ReservationDetails> reservationRoom) {
        this.reservationRoom = reservationRoom;
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
