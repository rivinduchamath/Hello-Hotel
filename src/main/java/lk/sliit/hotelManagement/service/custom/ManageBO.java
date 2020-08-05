package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface ManageBO extends SuperBO {
    void save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAllUser();

    void deleteEmployee(String userId);
}
