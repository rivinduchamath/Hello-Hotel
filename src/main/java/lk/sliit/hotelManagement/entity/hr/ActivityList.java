package lk.sliit.hotelManagement.entity.hr;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Date;


@Entity
public class ActivityList {

    @Id
    private int activityId;
    private int employeeId;
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private Date date;


    public ActivityList() {
    }

    public ActivityList(int activityId, int employeeId, String sunday, String monday,
                        String tuesday, String wednesday, String thursday, String friday, String saturday, Date date) {
        this.activityId = activityId;
        this.employeeId = employeeId;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.date = date;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
