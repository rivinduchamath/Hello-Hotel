package lk.sliit.hotelManagement.dto.hr;

public class DepartmentDTO {
    private int departmentId;
    private String departmentName;

    public DepartmentDTO(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public DepartmentDTO() {
    }

    public DepartmentDTO(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
