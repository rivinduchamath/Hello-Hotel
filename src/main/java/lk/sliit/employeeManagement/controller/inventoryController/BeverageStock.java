package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeverageStock {

    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/beverageStock")
    public String kitchenStock(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "beverageStock";
    }
}
