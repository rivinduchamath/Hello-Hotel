package lk.sliit.employeeManagement.entity.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemType {
    @Id
    String id;
    String userType;
    String submittedBy;

    public ItemType(String id, String userType, String submittedBy) {
        this.id = id;
        this.userType = userType;
        this.submittedBy = submittedBy;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public ItemType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

