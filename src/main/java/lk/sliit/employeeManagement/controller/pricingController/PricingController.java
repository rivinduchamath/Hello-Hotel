package lk.sliit.employeeManagement.controller.pricingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PricingController {
    @GetMapping("/pricing")
    public String loginPage(){
        return "pricing";
    }
}
