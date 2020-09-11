package lk.sliit.hotelManagement.dto.inventory;

public class ItemTypeDTO {

    int id;
    String userType;
    int submittedBy;

    public ItemTypeDTO(int id, String userType, int submittedBy) {
        this.id = id;
        this.userType = userType;
        this.submittedBy = submittedBy;
    }

    public ItemTypeDTO() {
    }

    public ItemTypeDTO(int id) {
        this.id = id;
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

    public int getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(int submittedBy) {
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


