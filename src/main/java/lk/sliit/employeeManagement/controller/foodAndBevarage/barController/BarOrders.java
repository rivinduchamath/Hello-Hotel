package lk.sliit.employeeManagement.controller.foodAndBevarage.barController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarOrders {
    @GetMapping("/barOrder")
    public String loginPage(){
        return "barOrder";
    }
}
