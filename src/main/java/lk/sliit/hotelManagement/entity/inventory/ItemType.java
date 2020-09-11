package lk.sliit.hotelManagement.entity.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemType {
    @Id
    int id;
    String userType;
    int submittedBy;

    public ItemType(int id, String userType, int submittedBy) {
        this.id = id;
        this.userType = userType;
        this.submittedBy = submittedBy;
    }

    public int getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(int submittedBy) {
        this.submittedBy = submittedBy;
    }

    public ItemType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

