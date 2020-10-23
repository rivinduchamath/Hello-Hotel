package lk.sliit.hotelManagement.controller.kitchenController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KitchenController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/kitchen")
    public String loginPage(Model model)
    {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<FoodItemDTO> foodItemDTOS = kitchenBO.findFoodItems();
        model.addAttribute("loadFoodItemTable",foodItemDTOS);
        return "kitchen";
    }

    @GetMapping("kitchenReport")
    public String loadKitchenReport(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "kitchenReport";
    }

}
