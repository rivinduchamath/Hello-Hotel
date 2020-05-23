package lk.sliit.employeeManagement.controller.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profile {
    @GetMapping("/profile")
    public String loginPage(){
        return "profile";
    }
}
