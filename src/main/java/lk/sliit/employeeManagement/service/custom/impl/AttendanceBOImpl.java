package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.AttendanceDAO;
import lk.sliit.employeeManagement.dao.EmployeeDAO;
import lk.sliit.employeeManagement.entity.hr.Attendance;
import lk.sliit.employeeManagement.service.custom.AttendanceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AttendanceBOImpl implements AttendanceBO {
    //Automate Object Creation
    @Autowired
    AttendanceDAO attendanceDAO;

    @Autowired
    EmployeeDAO employeeDAO;


}
