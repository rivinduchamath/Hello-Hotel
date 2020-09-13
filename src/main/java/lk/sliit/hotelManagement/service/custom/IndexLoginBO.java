package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface IndexLoginBO  extends SuperBO {

    EmployeeDTO findByIdNoAndPassword(int idNo, String password);

    EmployeeDTO getEmployeeByIdNo(int idNo);

    List<NoticeDTO> findResentNoticeDesc();


}
