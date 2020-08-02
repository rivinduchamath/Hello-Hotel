package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.dto.manager.NoticeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface IndexLoginBO  extends SuperBO {
    EmployeeDTO findByIdNoAndPassword(String idNo, String password);

    EmployeeDTO getEmployeeByIdNo(String idNo);

    List<NoticeDTO> findResentNoticeDesc();
}
