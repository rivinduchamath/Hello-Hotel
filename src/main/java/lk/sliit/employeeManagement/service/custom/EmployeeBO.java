package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

public interface EmployeeBO extends SuperBO {
    EmployeeDTO findByIdNoAndPassword(String idNo, String password);

    EmployeeDTO getEmployeeByIdNo(String idNo);
}
