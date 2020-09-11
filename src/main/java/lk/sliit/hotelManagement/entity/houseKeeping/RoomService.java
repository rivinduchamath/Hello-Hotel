package lk.sliit.hotelManagement.entity.houseKeeping;

import lk.sliit.hotelManagement.entity.manager.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class RoomService {
    @Id
    private int serviceId;
    private Date date;
    @Column(length = 1000)
    private String description;
    private String roomCondition;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", insertable = false, updatable = false)
    private HotelRoom roomId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private Employee empId;

    public RoomService(int serviceId, Date date, String description, String roomCondition, HotelRoom roomId, Employee empId) {
        this.serviceId = serviceId;
        this.date = date;
        this.description = description;
        this.roomCondition = roomCondition;
        this.roomId = roomId;
        this.empId = empId;
    }

    public RoomService() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoomCondition() {
        return roomCondition;
    }

    public void setRoomCondition(String roomCondition) {
        this.roomCondition = roomCondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HotelRoom getRoomId() {
        return roomId;
    }

    public void setRoomId(HotelRoom roomId) {
        this.roomId = roomId;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }
}
