package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface ManageBO extends SuperBO {
    void save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllUser();

    void deleteEmployee(String userId);
}
