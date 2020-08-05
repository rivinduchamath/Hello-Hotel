package lk.sliit.hotelManagement.entity.houseKeeping;

import lk.sliit.hotelManagement.entity.manager.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class RoomService {
    @Id
    private String serviceId;
    private Date date;
    private String status;
    @Column(length = 1000)
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", insertable = false, updatable = false)
    private HotelRoom roomId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private Employee empId;

    public RoomService(String serviceId, Date date, String status, String description, HotelRoom roomId, Employee empId) {
        this.serviceId = serviceId;
        this.date = date;
        this.status = status;
        this.description = description;
        this.roomId = roomId;
        this.empId = empId;
    }

    public RoomService() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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
