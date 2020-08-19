package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;

public interface MailSend {
    void sendMailToNewEmployee(EmployeeDTO employeeDTO);
}
