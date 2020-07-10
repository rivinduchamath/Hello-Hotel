package lk.sliit.employeeManagement.entity.manager;

import javax.persistence.Lob;
import lk.sliit.employeeManagement.entity.SuperEntity;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Blob;
@Entity
public class ManageUser implements SuperEntity {

    @Id
    private String userId ;
    private String name;
    private String position;
    private String address;
    private String password;
    private String salary;
    private String email;
    private String mobileNo;
    private String gender;
    private String  image;
    private Date date;


    public ManageUser(String userId, String name, String position, String address, String password,
                      String salary, String email, String mobileNo, String gender, String image, Date date) {
        this.userId = userId;
        this.name = name;
        this.position = position;
        this.address = address;
        this.password = password;
        this.salary = salary;
        this.email = email;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.image = image;
        this.date = date;
    }

    public ManageUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}//End Class
