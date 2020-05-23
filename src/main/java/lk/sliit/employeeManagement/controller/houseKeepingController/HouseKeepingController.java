package lk.sliit.employeeManagement.controller.houseKeepingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HouseKeepingController {
    @GetMapping("/rooms")
    public String loginPage(){
        return "housekeeping";
    }
}
