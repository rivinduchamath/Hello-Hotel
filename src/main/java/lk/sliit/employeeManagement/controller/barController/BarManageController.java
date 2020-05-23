package lk.sliit.employeeManagement.controller.barController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BarManageController {
    @GetMapping("/bar")
    public String loginPage(){
        return "bar";
    }
}
