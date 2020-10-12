package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AccountsDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.hr.SalaryDTO;
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

    List<EmployeeDTO> findAllUserwithOT();

    SalaryDTO findHighestSalaryId();

    SalaryDTO findSalarybyId(int salaryId);

    void saveSalary(SalaryDTO salaryDTO);

    List<SalaryDTO> findAllsalaryStateNotFalse();

    AccountsDTO findHighestAccountId();

    AccountsDTO findAccountById(int accountId);

    void saveAccounts(AccountsDTO accountsDTO);
}
