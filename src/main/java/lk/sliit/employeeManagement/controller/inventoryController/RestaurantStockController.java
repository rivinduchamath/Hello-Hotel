package lk.sliit.employeeManagement.controller.inventoryController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantStockController {
    @GetMapping("/restaurantStock")
    public String loginPage(){
        return "restaurantStock";
    }
}
