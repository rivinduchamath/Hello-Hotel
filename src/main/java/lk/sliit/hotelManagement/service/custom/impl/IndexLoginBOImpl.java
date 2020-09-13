package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.manageSystem.EmployeeDAO;
import lk.sliit.hotelManagement.dao.manageSystem.NoticeDAO;

import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class IndexLoginBOImpl implements IndexLoginBO {
    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    NoticeDAO noticeDAO;

    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;

    @Override
    public EmployeeDTO findByIdNoAndPassword(int idNo, String password) {
        Employee employee = employeeDAO.findByUserIdAndPassword(idNo, password);
        return new EmployeeDTO (
                employee.getUserId (),
                employee.getPassword ());
    }

    @Override
    public EmployeeDTO getEmployeeByIdNo(int idNo) {
        Employee employee = employeeDAO.findOne (idNo);
        return new EmployeeDTO (
                employee.getUserId(),
                employee.getName(),
                employee.getMobileNo(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPosition(),
                employee.getPassword(),
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getSalary(),
                employee.getDate(),
                employee.getImage(),
                employee.getDepartment().getDepartmentId()
        );

    }

    @Override
    public List<NoticeDTO> findResentNoticeDesc() {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable <Notice> allItems = noticeDAO.findAllByDateBetweenOrderByDateDesc( dt, todaydate);
        List <NoticeDTO> dtos = new ArrayList<>();
        for (Notice notice : allItems) {
            dtos.add(new NoticeDTO (
                    notice.getNoticeId (),
                    notice.getTitle (),
                    notice.getDescription (),
                    notice.getDate (),
                    notice.getDepartment().getDepartmentId()
            ));
        }
        return dtos;
    }


}
