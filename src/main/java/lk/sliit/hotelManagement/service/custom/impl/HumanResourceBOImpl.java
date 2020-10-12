package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.hrDAO.AccountsDAO;
import lk.sliit.hotelManagement.dao.hrDAO.AttendanceDAO;
import lk.sliit.hotelManagement.dao.hrDAO.DepartmentDAO;
import lk.sliit.hotelManagement.dao.hrDAO.SalaryDAO;
import lk.sliit.hotelManagement.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AccountsDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.hr.MonthlySalary;
import lk.sliit.hotelManagement.dto.hr.SalaryDTO;
import lk.sliit.hotelManagement.dto.hr.SalaryPay;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.hr.Accounts;
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
    @Autowired
    AccountsDAO accountsDAO;
    @Autowired
    DepartmentDAO departmentDAO;

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
                    a.getOtHours(),
                    a.getHours(),
                    a.getEmployeeID().getUserId(),
                    a.getEmployeeID().getName(),
                    a.getEmployeeID().getImage()

            ));
        }
        return dtos;
    }

    @Override
    public List<MonthlySalary> findAllUserwithOT() {

        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        List<Iterable<Double>> list = new ArrayList<>();
        Iterable<Employee> allTable = employeeDAO.findAll();

        Double all4 = 0.0;
        List<MonthlySalary> dtoList = new ArrayList<>();

        for (Employee a : allTable) {
            all4 = attendanceDAO.findAllByDateBetweenAndEmployeeID_UserIdEquals(dt, todaydate, a.getUserId());

            dtoList.add(new MonthlySalary(
                    a.getUserId(),
                    a.getName(),
                    a.getSalary(),
                    all4
            ));
        }

        return dtoList;
    }
    @Override
    public List<SalaryPay> getSalaryPayment(String source) {
        List<String> list = new ArrayList<String>();
        String[] sourceAry = source.split(" ");
        List<SalaryPay> dtoList = new ArrayList<>();
        for (String value : sourceAry) {
            list.add(value);
        }
        Double all4 = 0.0;
        Double all5 = 0.0;
        for (String aa : list) {
            int a = Integer.parseInt(aa);
          all4=  salaryDAO.findAllByDateBetweenAndEmployeeID_UserIdEquals(a);
          all5=  salaryDAO.findAllByDateBetweenAndEmployeeID_UserIdEqual(a);
            Employee employee = employeeDAO.findOne(Integer.valueOf(a));
            dtoList.add(new SalaryPay(
                    employee.getSalary(),
                    new Date(),
                    0,
                    0,
                    all5,
                    all4,
                    employee.getSalary(),
                    0,
                    false,
                    employee.getUserId()
            ));
        }
       /* Iterable <Salary> all = salaryDAO.findAll (list);
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getBasicSalary (),
                    salary.getOtHours (),
                    salary.getOtRate (),
                    salary.getBonus (),
                    salary.getIncomeTax (),
                    salary.getEmployeeID ()));
        }*/
        return dtoList;
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
                salary.getOtHours(),
                salary.getHours(),
                salary.getEmployeeID().getUserId()
        );
        return salaryDTO;
    }

    @Override
    public void saveSalary(SalaryDTO salary) {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        int m = (todaydate.getMonth());
        java.util.Date beforeWeek = cal.getTime();
        Employee employee = employeeDAO.findOne(salary.getEmployeeID());

        salaryDAO.save(new Salary(
                salary.getSalaryId(),
                salary.getOtHours(),
                salary.getHours(),
                false,
                new Date(),
                employee


        ));
    }

    @Override
    public List<SalaryDTO> findAllsalaryStateNotFalse() {
        Iterable<Salary> all = salaryDAO.findAllByStateAndDateEquals(false, new Date());

        List<SalaryDTO> dtos = new ArrayList<>();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO(
                    salary.getSalaryId(),
                    salary.getOtHours(),
                    salary.getHours(),
                    salary.getEmployeeID().getUserId(),
                    salary.getEmployeeID().getName(),
                    salary.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

    @Override
    public AccountsDTO findHighestAccountId() {
        Accounts accounts = null;
        try{
            accounts = accountsDAO.findTopByOrderByAccountIdDesc();
        }
        catch(Exception e){

        }
        return new AccountsDTO(accounts.getAccountId());
    }

    @Override
    public AccountsDTO findAccountById(int accountId) {
        Accounts accounts = accountsDAO.findOne(accountId);
        AccountsDTO accountsDTO = new AccountsDTO(
                accounts.getAccountId(),
                accounts.getChequeNo(),
                accounts.getAmount(),
                accounts.getDate(),
                accounts.getDepartment().getDepartmentId(),
                accounts.getDescription()
        );
        return accountsDTO;
    }

    @Override
    public void saveAccounts(AccountsDTO accountsDTO) {
        accountsDAO.save(new Accounts(
                accountsDTO.getAccountId(),
                accountsDTO.getChequeNo(),
                accountsDTO.getAmount(),
                accountsDTO.getDate(),
                accountsDTO.getDescription(),
                departmentDAO.findOne(accountsDTO.getDepartment())
        ));
    }
}
