package lk.sliit.employeeManagement.controller.dashboardController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.AttendanceDTO;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    AttendanceBO attendanceBO;
    @Autowired
    NoticeBO noticeBO;
    @RequestMapping("/dashboard")
    public String loginPage(Model model)
    {
        //Get Today Attendance
        List<AttendanceDTO> attendanceDTOS =attendanceBO.findTodayAttendance ( );
        int count =0;
        for (AttendanceDTO attendanceDTO: attendanceDTOS) {
            count++;
        }
        model.addAttribute ( "todayAttendance",attendanceDTOS );

        List<NoticeDTO> p = noticeBO.findAll();
        model.addAttribute("loadNoticeTable", p);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "dashboard";
    }
}
