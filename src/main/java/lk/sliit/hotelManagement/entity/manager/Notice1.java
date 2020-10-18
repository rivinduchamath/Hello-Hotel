package lk.sliit.hotelManagement.entity.manager;


import lk.sliit.hotelManagement.entity.SuperEntity;
import lk.sliit.hotelManagement.entity.hr.Department;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Notice1 implements SuperEntity {

    @Id
    private int noticeId ;
    private String title;
    @Column(length = 1000)
    private String description;
    private String date;


    public Notice1(int noticeId, String title, String description, String date) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;

    }

    public Notice1() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}//End Class
