package lk.sliit.employeeManagement.controller.foodAndBevarage.barController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BarBill {
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/barBill")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "barBill";
    }
}
