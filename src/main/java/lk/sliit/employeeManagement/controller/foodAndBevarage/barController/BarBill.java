package lk.sliit.employeeManagement.controller.foodAndBevarage.barController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BarBill {
    @PostMapping("/barBill")
    public String loginPage(){
        return "barBill";
    }
}
