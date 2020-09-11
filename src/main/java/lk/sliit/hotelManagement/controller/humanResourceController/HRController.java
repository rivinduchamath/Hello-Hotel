package lk.sliit.hotelManagement.controller.humanResourceController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HRController {

    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/hr")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "hr";
    }

    @GetMapping("/attendance")
    public String attendance(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "attendance";
    }
    @GetMapping("/salary")
    public String salary(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "salary";
    }

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

    @GetMapping("/roomsHR")
    public String roomsHR(Model model){
        model.addAttribute("loggerName",indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "roomsHR";
    }
}
