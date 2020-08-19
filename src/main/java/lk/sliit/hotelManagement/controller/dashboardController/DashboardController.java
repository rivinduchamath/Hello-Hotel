package lk.sliit.hotelManagement.controller.dashboardController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.service.custom.AttendanceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.NoticeBO;
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



        List<NoticeDTO> p = noticeBO.findAll();
        model.addAttribute("loadNoticeTable", p);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "dashboard";
    }
}
