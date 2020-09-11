package lk.sliit.hotelManagement.dto.inventory;

import java.sql.Date;

public class SupplierDTO {
    private int id;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private String gender;
    private Date date;
    private Date birthday;
    private String submittedBy;

    public SupplierDTO(int id, String name, String address, String mobile, String email, String gender, Date date, Date birthday, String submittedBy) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
        this.date = date;
        this.birthday = birthday;
        this.submittedBy = submittedBy;
    }

    public SupplierDTO(int id) {
        this.id = id;
    }

    public SupplierDTO() {
    }


    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", birthday=" + birthday +
                ", submittedBy='" + submittedBy + '\'' +
                '}';
    }
}
