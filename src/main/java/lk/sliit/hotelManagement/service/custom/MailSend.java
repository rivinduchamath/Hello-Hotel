package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.MailDTO;

public interface MailSend {
    void sendMailToNewEmployee(EmployeeDTO employeeDTO);

    void sendMailToCustomer(MailDTO mailDTO);
}
