package lk.sliit.hotelManagement.controller.humanResourceController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @GetMapping("/attendance")
    public String attendance(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUsers", p);
        model.addAttribute ( "listAttendance", humanResourceBO.findTodayAttendance ( ) );
        return "attendance";
    }

    @RequestMapping(value = "tablesAdd", method = RequestMethod.POST)
    public String addTodayAttendance(@ModelAttribute AttendanceDTO attendance, Model model) {

        DateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd" );
        Date date = new Date ( ); //Get Date
        attendance.setDate ( date ); //set today Date
        List <AttendanceDTO> todayAttendance = null;
        int eId = 0;
        int attendanceID = 0;
        int employeeID = 0;
        todayAttendance = humanResourceBO.findTodayAttendance ( );//Get All Today Attendance

        try {
            eId = attendance.getEmployeeID ( );//add EmployeeID From JSP
        } catch (NullPointerException e) {
            Logger.getLogger("lk.sliit.project.employeeManagement").log(Level.SEVERE, null,e); //Add Logger To Catch NullPointerException
            return "redirect:/attendance";//If NullPointerException, Reload Attendance.jsp
        }
        for (AttendanceDTO a : todayAttendance) {
            employeeID = a.getEmployeeID ( );//add EmployeeID From Attendance
            attendanceID = a.getAttendanceId ();//add AttendanceId From Attendance
            if (employeeID == ( eId )) {//Check JSP Employee ID Already in today attendance
                attendance.setAttendanceId ( attendanceID ); //IF true Set Attendance Id and save
                humanResourceBO.saveOrUpdate ( attendance );
                return "redirect:/attendance";
            }
        }


        try {
            AttendanceDTO totalCount = humanResourceBO.findTopByOrderByAttendanceIdDesc ( );
            int x =  ( totalCount.getAttendanceId ( ) )+ 1;
            attendance.setAttendanceId(  x);
        } catch (NullPointerException e) {
            attendance.setAttendanceId( 1);
        }

        humanResourceBO.saveOrUpdate ( attendance );//Else Attendance Save Under Previous Attendance ID
        return "redirect:/attendance";
    }//End addTodayAttendance Method



    @GetMapping("/accounts")
    public String accounts(Model model){
        model.addAttribute("loggerName",indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "accounts";
    }

    @GetMapping("/accountsReport")
    public String accountsReport(Model model){
        model.addAttribute("loggerName",indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "accountsReport";
    }
    @RequestMapping("deleteAttendance")
    public String deleteUserAttendance(@RequestParam int pid, HttpServletRequest request) {
        humanResourceBO.deleteAttendance ( pid );
        //Get All Employees After Delete
     //   request.setAttribute ( "listEmployeesTable", humanResourceBO.findAllEmployees ( ) );
        return "redirect:/attendance";
    }

}
