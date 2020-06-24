package lk.sliit.employeeManagement.controller.kitchenController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodItemManageController {
    @Autowired
    IndexLoginBO indexLoginBO;

@GetMapping("/foodItemManagement")
public String loginPage(Model model)
{
    model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
    return "foodItemManagement";
}
    @PostMapping("/addNewFoodItems")
    public String addNew(Model model)
    {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "addNewFoodItems";
    }
}
