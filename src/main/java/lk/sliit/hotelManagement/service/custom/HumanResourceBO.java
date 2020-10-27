package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.*;

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

    AccountsDTO findHighestAccountId();

    AccountsDTO findAccountById(int accountId);

    void saveAccounts(AccountsDTO accountsDTO);

    List<SalaryPayDTO> getSalaryPayment(String source);

    List<AccountsDTO> findAllAccounts();

    void deleteAccount(int accountId);

    List<EmployeeDTO> findAllsalaryStateNotFalseTot();

    List<SalarySettingsDTO> getSalarySet();

    void saveSettingSalary(SalarySettingsDTO settingsDTO);

    SalarySettingsDTO findsalarySettingById(int id);

    SalarySettingsDTO findHighestSettingSalary();

    ActivityListDTO findHighestActivityId();

    ActivityListDTO findActivityById(int activityId);

    void saveActivity(ActivityListDTO activityListDTO1);

    List<ActivityListDTO> findAllActivity();

    void deleteActivity(int activityId);
}
