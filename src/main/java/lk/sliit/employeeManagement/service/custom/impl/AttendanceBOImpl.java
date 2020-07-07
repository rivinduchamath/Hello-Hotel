package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.AttendanceDAO;
import lk.sliit.employeeManagement.dao.EmployeeDAO;
import lk.sliit.employeeManagement.dto.AttendanceDTO;
import lk.sliit.employeeManagement.entity.Attendance;
import lk.sliit.employeeManagement.service.custom.AttendanceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class AttendanceBOImpl implements AttendanceBO {
    //Automate Object Creation
    @Autowired
    AttendanceDAO attendanceDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<AttendanceDTO> findTodayAttendance() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Iterable <Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAttendanceByDateEquals (date );
        }catch (Exception e){
           }
        List <AttendanceDTO> dtos = new ArrayList<>( );
        for (Attendance attendance : attendances) {
            dtos.add ( new AttendanceDTO (
                    attendance.getAttendanceId (),
                    attendance.getSalary (),
                    attendance.getDate (),
                    attendance.getInTime (),
                    attendance.getOutTime (),
                    attendance.getOvertimeHours (),
                    employeeDAO.findOne ( attendance.getEmployeeID ().getIdNo () )
            ) );
        }
        return dtos;
    }//End findTodayAttendance Method
}
