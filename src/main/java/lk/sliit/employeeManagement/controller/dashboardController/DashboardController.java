package lk.sliit.employeeManagement.controller.dashboardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String loginPage(){
        return "dashboard";
    }
}
