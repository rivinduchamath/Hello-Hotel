package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.hr.MonthlySalary;
import lk.sliit.hotelManagement.dto.hr.SalaryDTO;
import lk.sliit.hotelManagement.dto.hr.SalaryPay;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface HumanResourceBO extends SuperBO {
    void updateRoomHR(HotelRoomDTO hotelRoomDTO);

    List<AttendanceDTO> findTodayAttendance();

    void saveOrUpdate(AttendanceDTO attendance);
    AttendanceDTO findTopByOrderByAttendanceIdDesc();

    void deleteAttendance(int pid);

    List<AttendanceDTO> findTodayCleanAttendance();

    List<SalaryDTO> findAllSalary();

    List<MonthlySalary> findAllUserwithOT();

    SalaryDTO findHighestSalaryId();

    SalaryDTO findSalarybyId(int salaryId);

    void saveSalary(SalaryDTO salaryDTO);

    List<SalaryDTO> findAllsalaryStateNotFalse();

    List<SalaryPay> getSalaryPayment(String source);
}
