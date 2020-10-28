package lk.sliit.hotelManagement.controller.foodAndBevarage;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDetailDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import lk.sliit.hotelManagement.service.custom.impl.BarBOImpl;
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
    @Autowired
    BarBOImpl barBO;

    @GetMapping("/foodAndBeverage")//Load FoodBev Dashboard
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
