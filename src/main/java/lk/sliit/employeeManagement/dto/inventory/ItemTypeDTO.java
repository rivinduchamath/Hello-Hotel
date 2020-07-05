package lk.sliit.employeeManagement.dto.inventory;

public class ItemTypeDTO {

    String id;
    String userType;

    public ItemTypeDTO(String id, String userType) {
        this.id = id;
        this.userType = userType;
    }

    public ItemTypeDTO() {
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

    @Override
    public String toString() {
        return "ItemType{" +
                "id='" + id + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}


