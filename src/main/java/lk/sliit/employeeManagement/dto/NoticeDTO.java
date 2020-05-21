package lk.sliit.employeeManagement.dto;


import java.sql.Date;

//Class NoticeDTO
public class NoticeDTO {

    private String noticeId ;
    private String title;
    private String description;
    private Date date;

    public NoticeDTO(String noticeId, String title, String description, Date date) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public NoticeDTO() {
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

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End DTO
