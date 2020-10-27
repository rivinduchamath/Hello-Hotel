package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.MailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;

public interface MailSend {
    void sendMailToNewEmployee(EmployeeDTO employeeDTO);

    void sendMailToCustomer(MailDTO mailDTO);

    void sendMailToOnlineCustomer(RestaurantOnlineOrderDTO onlineOrderDTO);
}
