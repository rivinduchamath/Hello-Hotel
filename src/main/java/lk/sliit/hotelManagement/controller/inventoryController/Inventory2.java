package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Inventory2 {

    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/addInventory2")
    public String kitchenStock(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "addInventory2";
    }
}
