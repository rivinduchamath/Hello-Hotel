package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.hrDAO.AttendanceDAO;
import lk.sliit.hotelManagement.dao.manageSystem.EmployeeDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.hr.Attendance;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
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
public class HumanResourceBOImpl implements HumanResourceBO {
    @Autowired
    HouseKeepingDAO houseKeepingDAO;
    @Autowired
    AttendanceDAO attendanceDAO;
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public void updateRoomHR(HotelRoomDTO hotelRoomDTO) {

        houseKeepingDAO.save(new HotelRoom(
                hotelRoomDTO.getRoomId2(),
                hotelRoomDTO.getRoomName(),
                hotelRoomDTO.getRoomType(),
                hotelRoomDTO.getDescription(),
                hotelRoomDTO.getStatus(),
                hotelRoomDTO.getHolder(),
                hotelRoomDTO.getPrice(),
                hotelRoomDTO.getDate()

        ));
    }

    @Override
    public List<AttendanceDTO> findTodayAttendance() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Iterable<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAttendanceByDateEquals(date);
        } catch (Exception e) {
        }
        List<AttendanceDTO> dtos = new ArrayList<>();
        for (Attendance attendance : attendances) {
            dtos.add(new AttendanceDTO(
                    attendance.getAttendanceId(),
                    attendance.getDate(),
                    attendance.getInTime(),
                    attendance.getOutTime(),
                    attendance.getOvertimeHours(),
                    attendance.getEmployeeID().getUserId(),
                    attendance.getEmployeeID().getName(),
                    attendance.getEmployeeID().getPosition(),
                    attendance.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

    //Save Attendance If Not Already Add Today
    @Override
    public void saveOrUpdate(AttendanceDTO attendanceDTO) {
        attendanceDAO.save(new Attendance(
                attendanceDTO.getAttendanceId(),
                attendanceDTO.getDate(),
                attendanceDTO.getSalary(),
                attendanceDTO.getInTime(),
                attendanceDTO.getOutTime(),
                attendanceDTO.getOvertimeHours(),
                employeeDAO.findOne(attendanceDTO.getEmployeeID())));
    }//End attendance save method

    @Override
    @Transactional(readOnly = true)
    public AttendanceDTO findTopByOrderByAttendanceIdDesc() {
        Attendance attendance = null;
        try {
            attendance = attendanceDAO.findTopByOrderByAttendanceIdDesc ();
        }catch (Exception e){
            Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        return new AttendanceDTO (
                attendance.getAttendanceId ()
        );
    }//End Get Total Emp

    @Override//Delete Attendance
    public void deleteAttendance(int id) {
        attendanceDAO.delete (id);
    }

    @Override
    public   List<AttendanceDTO> findTodayCleanAttendance() {
        Date date = new Date();
        Iterable<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAttendanceByDateEquals(date);
        } catch (Exception e) {
        }
        List<AttendanceDTO> dtos = new ArrayList<>();
        for (Attendance attendance : attendances) {
            dtos.add(new AttendanceDTO(
                    attendance.getAttendanceId(),
                    attendance.getDate(),
                    attendance.getInTime(),
                    attendance.getOutTime(),
                    attendance.getOvertimeHours(),
                    attendance.getEmployeeID().getUserId(),
                    attendance.getEmployeeID().getName(),
                    attendance.getEmployeeID().getPosition(),
                    attendance.getEmployeeID().getImage(),
                    attendance.getEmployeeID().getDepartment().getDepartmentName()
            ));
        }
        return dtos;
    }
}
