package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.hrDAO.AttendanceDAO;
import lk.sliit.employeeManagement.dao.manageSystem.EmployeeDAO;
import lk.sliit.employeeManagement.service.custom.AttendanceBO;
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
