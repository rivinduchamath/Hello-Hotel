package lk.sliit.employeeManagement.controller.humanResourceController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HRController {
    @GetMapping("/hr")
    public String loginPage(){
        return "hr";
    }
}
