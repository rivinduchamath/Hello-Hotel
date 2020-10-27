package lk.sliit.hotelManagement.controller.humanResourceController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.AccountsDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.hr.SalaryDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class HRController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;
    @Autowired
    HumanResourceBO humanResourceBO;

    @GetMapping("/hr")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "hr";
    }

    @GetMapping("/inventoryBillsHR")
    public String inventoryBills(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "inventoryBillsHR";
    }

    @GetMapping("/allAttendance")
    public String allAttendance(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUsers", p);
        model.addAttribute("listAttendance", humanResourceBO.findTodayAttendance());
        return "allAttendance";
    }

    @GetMapping("/attendance")
    public String attendance(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUsers", p);
        model.addAttribute("listAttendance", humanResourceBO.findTodayAttendance());
        return "attendance";
    }

    @RequestMapping(value = "tablesAdd", method = RequestMethod.POST)
    public String addTodayAttendance(@ModelAttribute AttendanceDTO attendance, Model model) {

        String start = attendance.getInTime();
        String end = attendance.getOutTime();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(start);
            date2 = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = date2.getTime() - date1.getTime();
        double hours = (int) TimeUnit.MILLISECONDS.toHours(difference);

        Date date = new Date(); //Get Date
        attendance.setDate(date); //set today Date
        List<AttendanceDTO> todayAttendance = null;
        int eId = 0;
        int attendanceID = 0;
        int employeeID = 0;
        todayAttendance = humanResourceBO.findTodayAttendance();//Get All Today Attendance

        try {
            eId = attendance.getEmployeeID();//add EmployeeID From JSP
        } catch (NullPointerException e) {
            return "redirect:/attendance";//If NullPointerException, Reload Attendance.jsp
        }
        for (AttendanceDTO a : todayAttendance) {
            employeeID = a.getEmployeeID();//add EmployeeID From Attendance
            attendanceID = a.getAttendanceId();//add AttendanceId From Attendance
            if (employeeID == (eId)) {//Check JSP Employee ID Already in today attendance
                attendance.setAttendanceId(attendanceID); //IF true Set Attendance Id and save
                humanResourceBO.saveOrUpdate(attendance);
                salaryManage(eId, attendance.getOvertimeHours() , hours);
                return "redirect:/attendance";
            }
        }
        try {


            AttendanceDTO totalCount = humanResourceBO.findTopByOrderByAttendanceIdDesc();
            int x = (totalCount.getAttendanceId()) + 1;
            attendance.setAttendanceId(x);
        } catch (NullPointerException e) {
            attendance.setAttendanceId(1);
        }
        newSalaryManage(attendance.getEmployeeID(),attendance.getOvertimeHours(),hours);
        humanResourceBO.saveOrUpdate(attendance);

        return "redirect:/attendance";
    }//End addTodayAttendance Method

    private void newSalaryManage(int eId, double overtimeHours,double hours) {
        SalaryDTO totalCount = new SalaryDTO();
        try {
            totalCount = humanResourceBO.findHighestSalaryId();
            int x = (totalCount.getSalaryId()) + 1;
            totalCount.setSalaryId(x);
        } catch (NullPointerException e) {

            totalCount.setSalaryId(1);
        }
        totalCount.setEmployeeID(eId);
        totalCount.setHours(hours);
        totalCount.setOtHours(overtimeHours);

        humanResourceBO.saveSalary(totalCount);

    }

    private void salaryManage(int eId, double ot,double hours) {
        List<SalaryDTO> salaryDTOS = null;
        int employeeID = 0, salaryId = 0;
        salaryDTOS = humanResourceBO.findAllsalaryStateNotFalse();
        for (SalaryDTO a : salaryDTOS) {
            employeeID = a.getEmployeeID();
            salaryId = a.getSalaryId();
            if (employeeID == (eId)) {
                a.setOtHours(ot);
                a.setSalaryId(salaryId);
                a.setHours(hours);
                humanResourceBO.saveSalary(a);
            }
        }
    }

    @GetMapping("/accountsReport")
    public String accountsReport(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "accountsReport";
    }

    @RequestMapping("deleteAttendance")
    public String deleteUserAttendance(@RequestParam int pid, HttpServletRequest request) {
        humanResourceBO.deleteAttendance(pid);
        //Get All Employees After Delete
        //   request.setAttribute ( "listEmployeesTable", humanResourceBO.findAllEmployees ( ) );
        return "redirect:/attendance";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        List<DepartmentDTO> p2 = manageBO.findAllDepartment();
        model.addAttribute("loadDepartment", p2);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<AccountsDTO> p3 = humanResourceBO.findAllAccounts();
        model.addAttribute("loadAccounts", p3);
        return "accounts";
    }

    @RequestMapping(value = "deleteAccounts/{accountId}")
    public void deleteEmployee(@PathVariable("accountId") int accountId, HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        humanResourceBO.deleteAccount(accountId);
        response.sendRedirect("/accounts");
    }

    @PostMapping("/saveAccount")
    public String saveAccounts(@ModelAttribute AccountsDTO accountsDTO, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            AccountsDTO accountsDTO1 = humanResourceBO.findHighestAccountId();
            AccountsDTO accountsDTO2 = null;
            try {
                accountsDTO2 = humanResourceBO.findAccountById(accountsDTO.getAccountId());
            } catch (NullPointerException d) {
                int maxId = (accountsDTO1.getAccountId());
                if (accountsDTO.getAccountId() == (maxId)) {
                    accountsDTO.setAccountId((maxId));
                } else {
                    maxId++;
                    accountsDTO.setAccountId(maxId);
                }
            }
        } catch (NullPointerException e) {
            accountsDTO.setAccountId(1);
        }
        humanResourceBO.saveAccounts(accountsDTO);
        return "redirect:/accounts";
    }

}