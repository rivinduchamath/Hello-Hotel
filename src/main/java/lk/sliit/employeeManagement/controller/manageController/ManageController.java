package lk.sliit.employeeManagement.controller.manageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageController {
    @GetMapping("/manage")
    public String loginPage(){
        return "manage";
    }
}
