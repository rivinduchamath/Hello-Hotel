package lk.sliit.hotelManagement.dto.inventory;

public class ItemTypeDTO {

    String id;
    String userType;
    String submittedBy;

    public ItemTypeDTO(String id, String userType, String submittedBy) {
        this.id = id;
        this.userType = userType;
        this.submittedBy = submittedBy;
    }

    public ItemTypeDTO() {
    }

    public ItemTypeDTO(String id) {
        this.id = id;
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

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Override
    public String toString() {
        return "ItemTypeDTO{" +
                "id='" + id + '\'' +
                ", userType='" + userType + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                '}';
    }
}


