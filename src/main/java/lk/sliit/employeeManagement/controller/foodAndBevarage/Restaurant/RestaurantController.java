package lk.sliit.employeeManagement.controller.foodAndBevarage.Restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {
    @GetMapping("/restaurant")
    public String loginPage(){
        return "restaurant";
    }
}
