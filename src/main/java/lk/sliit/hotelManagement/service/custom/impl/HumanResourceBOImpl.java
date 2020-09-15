package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.hrDAO.AttendanceDAO;
import lk.sliit.hotelManagement.dao.hrDAO.SalaryDAO;
import lk.sliit.hotelManagement.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.hr.SalaryDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.hr.Attendance;
import lk.sliit.hotelManagement.entity.hr.Salary;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    SalaryDAO salaryDAO;
    @Autowired
    EmployeeDAO manageDAO;

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
            attendance = attendanceDAO.findTopByOrderByAttendanceIdDesc();
        } catch (Exception e) {
            Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null, e); //Add Logger To Catch Exception
        }
        return new AttendanceDTO(
                attendance.getAttendanceId()
        );
    }//End Get Total Emp

    @Override//Delete Attendance
    public void deleteAttendance(int id) {
        attendanceDAO.delete(id);
    }

    @Override
    public List<AttendanceDTO> findTodayCleanAttendance() {
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

    @Override
    public List<SalaryDTO> findAllSalary() {
        Iterable<Salary> all = salaryDAO.findAll();
        List<SalaryDTO> dtos = new ArrayList<>();
        for (Salary a : all) {
            dtos.add(new SalaryDTO(
                    a.getSalaryId(),
                    a.getBasicSalary(),
                    a.getEtf(),
                    a.getEpf(),
                    a.getServiceCharge(),
                    a.getOtHours(),
                    a.getHours(),
                    a.getSalary(),
                    a.getEmployeeID().getUserId(),
                    a.getEmployeeID().getName(),
                    a.getEmployeeID().getImage()

            ));
        }
        return dtos;
    }

    @Override
    public List<EmployeeDTO> findAllUserwithOT() {
        Iterable<Employee> all = manageDAO.findAll();

        List<EmployeeDTO> dtos = new ArrayList<>();
        for (Employee employee : all) {
            dtos.add(new EmployeeDTO(
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
            ));
        }
        return dtos;
    }

    @Override
    public SalaryDTO findHighestSalaryId() {
        Salary salary = null;
        try {
            salary = salaryDAO.findTopByOrderBySalaryIdDesc();
        } catch (Exception e) {
        }
        return new SalaryDTO(
                salary.getSalaryId()
        );
    }//End Get Total Emp


    @Override
    public SalaryDTO findSalarybyId(int salaryId) {
        Salary salary = salaryDAO.findOne(salaryId);
        SalaryDTO salaryDTO = new SalaryDTO(
                salary.getSalaryId(),
                salary.getBasicSalary(),
                salary.getEtf(),
                salary.getEpf(),
                salary.getServiceCharge(),
                salary.getOtHours(),
                salary.getHours(),
                salary.getSalary(),
                salary.getEmployeeID().getUserId()
        );
        return salaryDTO;
    }

    @Override
    public void saveSalary(SalaryDTO salary) {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        int m =(todaydate.getMonth());
        java.util.Date beforeWeek = cal.getTime();

     Employee employee =  employeeDAO.findOne(salary.getEmployeeID());

//
        salaryDAO.save(new Salary(
                salary.getSalaryId(),
                salary.getBasicSalary(),
                salary.getEtf(),
                salary.getEpf(),
                salary.getServiceCharge(),
                salary.getOtHours(),
                salary.getHours(),
                salary.getSalary(),
                false,
                new Date(),
                employee


        ));
    }

    @Override
    public List<SalaryDTO> findAllsalaryStateNotFalse() {
        Iterable<Salary> all = salaryDAO.findAllByStateEquals(false);

        List<SalaryDTO> dtos = new ArrayList<>();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO(
                    salary.getSalaryId(),
                    salary.getBasicSalary(),
                    salary.getEtf(),
                    salary.getEpf(),
                    salary.getServiceCharge(),
                    salary.getOtHours(),
                    salary.getHours(),
                    salary.getSalary(),
                    salary.getEmployeeID().getUserId(),
                    salary.getEmployeeID().getName(),
                    salary.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

}
