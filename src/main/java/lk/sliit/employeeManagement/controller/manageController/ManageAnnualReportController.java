package lk.sliit.employeeManagement.controller.manageController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageAnnualReportController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/manageAnnualReport")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "manageAnnualReport";
    }
}
