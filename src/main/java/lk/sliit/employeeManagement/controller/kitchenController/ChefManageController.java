package lk.sliit.employeeManagement.controller.kitchenController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChefManageController {
    @Autowired
    IndexLoginBO indexLoginBO;

@GetMapping("/chefManagement")
public String loginPage(Model model)
{
    model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
    return "chefManagement";
}
    @GetMapping("/chefList")
    public String chefList(Model model)
    {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "chefList";
    }
}
