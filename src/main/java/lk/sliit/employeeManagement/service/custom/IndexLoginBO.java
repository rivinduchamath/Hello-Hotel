package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

public interface IndexLoginBO  extends SuperBO {
    EmployeeDTO findByIdNoAndPassword(String idNo, String password);

    EmployeeDTO getEmployeeByIdNo(String idNo);
}
