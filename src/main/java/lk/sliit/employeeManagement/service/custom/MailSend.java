package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;

public interface MailSend {
    void sendMailToNewEmployee(EmployeeDTO employeeDTO);
}
