package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.hrDAO.AttendanceDAO;
import lk.sliit.hotelManagement.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotelManagement.service.custom.AttendanceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttendanceBOImpl implements AttendanceBO {
    //Automate Object Creation
    @Autowired
    AttendanceDAO attendanceDAO;

    @Autowired
    EmployeeDAO employeeDAO;


}
