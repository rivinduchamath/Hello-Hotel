package lk.sliit.hotelManagement.controller.foodAndBevarage;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FoodAndBeverage {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/foodAndBeverage")//Load FoodBev Dashboard
    public String loadFAndB(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<FoodItemDTO> p1 = kitchenBO.findFoodItems();
        model.addAttribute("d1", p1.get(0));
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
