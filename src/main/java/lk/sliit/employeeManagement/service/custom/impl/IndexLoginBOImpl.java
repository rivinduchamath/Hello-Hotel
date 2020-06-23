package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.EmployeeDAO;
import lk.sliit.employeeManagement.dao.NoticeDAO;
import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.entity.Employee;
import lk.sliit.employeeManagement.entity.Notice;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
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

    @Override
    public EmployeeDTO findByIdNoAndPassword(String idNo, String password) {
        Employee employee = employeeDAO.findByIdNoAndPassword(idNo, password);
        return new EmployeeDTO (
                employee.getIdNo (),
                employee.getPassword ());
    }

    @Override
    public EmployeeDTO getEmployeeByIdNo(String idNo) {
        Employee employee = employeeDAO.findOne (idNo);
        return new EmployeeDTO (employee.getIdNo (),
                employee.getName (),
                employee.getMobileNumber (),
                employee.getEmail (),
                employee.getAddress (),
                employee.getOccupation (),
                employee.getPassword (),
                employee.getDateOfBirth (),
                employee.getGender (),
                employee.getDate (),
                employee.getPic (),
                employee.isAdmin ()
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
                    notice.getDate ()
            ));
        }
        return dtos;
    }
}
