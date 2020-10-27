package lk.sliit.hotelManagement.dto.hr;


import java.sql.Date;

public class ActivityListDTO {
    private int activityId;
    private int employeeId;
    private String name;
    private String sundayIn;
    private String sundayOut;
    private String mondayIn;
    private String mondayOut;
    private String tuesdayIn;
    private String tuesdayOut;
    private String wednesdayIn;
    private String wednesdayOut;
    private String thursdayIn;
    private String thursdayOut;
    private String fridayIn;
    private String fridayOut;
    private String saturdayIn;
    private String saturdayOut;
    private Date date;



    public ActivityListDTO() {
    }

    public ActivityListDTO(int activityId, int employeeId, String sundayIn, String sundayOut, String mondayIn, String mondayOut, String tuesdayIn, String tuesdayOut, String wednesdayIn, String wednesdayOut, String thursdayIn, String thursdayOut, String fridayIn, String fridayOut, String saturdayIn, String saturdayOut, Date date) {
        this.activityId = activityId;
        this.employeeId = employeeId;
        this.sundayIn = sundayIn;
        this.sundayOut = sundayOut;
        this.mondayIn = mondayIn;
        this.mondayOut = mondayOut;
        this.tuesdayIn = tuesdayIn;
        this.tuesdayOut = tuesdayOut;
        this.wednesdayIn = wednesdayIn;
        this.wednesdayOut = wednesdayOut;
        this.thursdayIn = thursdayIn;
        this.thursdayOut = thursdayOut;
        this.fridayIn = fridayIn;
        this.fridayOut = fridayOut;
        this.saturdayIn = saturdayIn;
        this.saturdayOut = saturdayOut;
        this.date = date;
    }

    public ActivityListDTO(int activityId) {
        this.activityId = activityId;
    }

    public ActivityListDTO(int activityId, int employeeId, String name, String monday, String sunday,
                           String tuesday, String wednesday, String thursday, String friday, String saturday,Date date) {

        this.activityId = activityId;
        this.employeeId = employeeId;
        this.name =name;
        this.sundayIn = sunday;
        this.mondayIn = monday;
        this.tuesdayIn = tuesday;
        this.wednesdayIn = wednesday;
        this.thursdayIn = thursday;
        this.fridayIn = friday;
        this.saturdayIn = saturday;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSundayIn() {
        return sundayIn;
    }

    public void setSundayIn(String sundayIn) {
        this.sundayIn = sundayIn;
    }

    public String getSundayOut() {
        return sundayOut;
    }

    public void setSundayOut(String sundayOut) {
        this.sundayOut = sundayOut;
    }

    public String getMondayIn() {
        return mondayIn;
    }

    public void setMondayIn(String mondayIn) {
        this.mondayIn = mondayIn;
    }

    public String getMondayOut() {
        return mondayOut;
    }

    public void setMondayOut(String mondayOut) {
        this.mondayOut = mondayOut;
    }

    public String getTuesdayIn() {
        return tuesdayIn;
    }

    public void setTuesdayIn(String tuesdayIn) {
        this.tuesdayIn = tuesdayIn;
    }

    public String getTuesdayOut() {
        return tuesdayOut;
    }

    public void setTuesdayOut(String tuesdayOut) {
        this.tuesdayOut = tuesdayOut;
    }

    public String getWednesdayIn() {
        return wednesdayIn;
    }

    public void setWednesdayIn(String wednesdayIn) {
        this.wednesdayIn = wednesdayIn;
    }

    public String getWednesdayOut() {
        return wednesdayOut;
    }

    public void setWednesdayOut(String wednesdayOut) {
        this.wednesdayOut = wednesdayOut;
    }

    public String getThursdayIn() {
        return thursdayIn;
    }

    public void setThursdayIn(String thursdayIn) {
        this.thursdayIn = thursdayIn;
    }

    public String getThursdayOut() {
        return thursdayOut;
    }

    public void setThursdayOut(String thursdayOut) {
        this.thursdayOut = thursdayOut;
    }

    public String getFridayIn() {
        return fridayIn;
    }

    public void setFridayIn(String fridayIn) {
        this.fridayIn = fridayIn;
    }

    public String getFridayOut() {
        return fridayOut;
    }

    public void setFridayOut(String fridayOut) {
        this.fridayOut = fridayOut;
    }

    public String getSaturdayIn() {
        return saturdayIn;
    }

    public void setSaturdayIn(String saturdayIn) {
        this.saturdayIn = saturdayIn;
    }

    public String getSaturdayOut() {
        return saturdayOut;
    }

    public void setSaturdayOut(String saturdayOut) {
        this.saturdayOut = saturdayOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActivityListDTO{" +
                "activityId=" + activityId +
                ", employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", sundayIn='" + sundayIn + '\'' +
                ", sundayOut='" + sundayOut + '\'' +
                ", mondayIn='" + mondayIn + '\'' +
                ", mondayOut='" + mondayOut + '\'' +
                ", tuesdayIn='" + tuesdayIn + '\'' +
                ", tuesdayOut='" + tuesdayOut + '\'' +
                ", wednesdayIn='" + wednesdayIn + '\'' +
                ", wednesdayOut='" + wednesdayOut + '\'' +
                ", thursdayIn='" + thursdayIn + '\'' +
                ", thursdayOut='" + thursdayOut + '\'' +
                ", fridayIn='" + fridayIn + '\'' +
                ", fridayOut='" + fridayOut + '\'' +
                ", saturdayIn='" + saturdayIn + '\'' +
                ", saturdayOut='" + saturdayOut + '\'' +
                ", date=" + date +
                '}';
    }
}
