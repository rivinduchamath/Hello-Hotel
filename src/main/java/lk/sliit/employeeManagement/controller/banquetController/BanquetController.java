package lk.sliit.employeeManagement.controller.banquetController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanquetController {
    @GetMapping("/banquets")
    public String loginPage(){
        return "banquet";
    }
}
