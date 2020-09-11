package lk.sliit.hotelManagement.dto.manager;


import lk.sliit.hotelManagement.entity.hr.Department;
import java.sql.Date;

//Class NoticeDTO
public class NoticeDTO {
    private int noticeId ;
    private String title;
    private String description;
    private Date date;
    private int department;



    public NoticeDTO() {
    }

    public NoticeDTO(int noticeId, String title, String description, Date date, int department) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.department = department;
    }

    public NoticeDTO(int noticeId) {
        this.noticeId = noticeId;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
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

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
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
