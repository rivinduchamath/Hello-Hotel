package lk.sliit.hotelManagement.dto.manager;


import lk.sliit.hotelManagement.entity.hr.Department;
import java.sql.Date;

//Class NoticeDTO
public class NoticeDTO {
    private String noticeId ;
    private String title;
    private String description;
    private Date date;
    private Department department;

    public NoticeDTO(String noticeId, String title, String description, Date date) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public NoticeDTO() {
    }

    public NoticeDTO(String noticeId, String title, String description, Date date, Department department) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.department = department;
    }

    public NoticeDTO(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", department=" + department +
                '}';
    }
}//End DTO
