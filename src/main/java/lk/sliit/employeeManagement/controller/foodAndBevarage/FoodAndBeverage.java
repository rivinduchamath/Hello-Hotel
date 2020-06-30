package lk.sliit.employeeManagement.controller.foodAndBevarage;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodAndBeverage {
    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/foodAndBeverage")
    public String loadFAndB(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "foodAndBeverage";
    }
    @GetMapping("/beverageDailyActivityReport")
    public String barDailyReport(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "beverageDailyActivityReport";
    }
    @GetMapping("/restaurantDailyActivityReport")
    public String restaurantReport(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurantDailyActivityReport";
    }
}
