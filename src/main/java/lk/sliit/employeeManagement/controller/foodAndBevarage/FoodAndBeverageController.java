package lk.sliit.employeeManagement.controller.foodAndBevarage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodAndBeverageController {
    @GetMapping("/foodAndBev")
    public String loginPage(){
        return "restaurant";
    }
}
