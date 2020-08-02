package lk.sliit.employeeManagement.controller.indexController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.manager.EmployeeDTO;
import lk.sliit.employeeManagement.dto.manager.NoticeDTO;
import lk.sliit.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController { //index.jsp Page Controller
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    NoticeBO noticeBO;

    @Autowired
    AttendanceBO attendanceBO;

    @GetMapping("/")
    public String loginPage() {
        return "index";
    }

    @RequestMapping("login")
    public String loginPage1() {
        return "index";
    }

    @RequestMapping("Dashboard") // Load dashboard.jsp Page If Id And password is mach
    public String registerUser(@ModelAttribute EmployeeDTO employee, Model model) {
        //True If Id and password is match
        if (indexLoginBO.findByIdNoAndPassword(employee.getUserId(), employee.getPassword()) != null) {

            //Get Today Attendance

            model.addAttribute ( "todayAttendance",null );

            //Add Logger Id To the static variable idNo
            SuperController.idNo = employee.getUserId();
            //Get Logger Data
            model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
            List<NoticeDTO> p = noticeBO.findAll();
            model.addAttribute("loadNoticeTable", p);
            return "/dashboard";
        } else {//If User name And Password is not match
            return "redirect:/login";
        }
    }//End method
}//End class
