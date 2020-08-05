package lk.sliit.hotelManagement.dto.houseKeeping;

import java.sql.Date;

public class RoomServiceDTO {
    private String serviceId;
    private Date date;
    private String status;
    private String description;
    private String roomId;
    private String empId;

    public RoomServiceDTO(String serviceId, Date date, String status, String description, String roomId, String empId) {
        this.serviceId = serviceId;
        this.date = date;
        this.status = status;
        this.description = description;
        this.roomId = roomId;
        this.empId = empId;
    }

    public RoomServiceDTO() {
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "RoomServiceDTO{" +
                "serviceId='" + serviceId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", roomId='" + roomId + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
