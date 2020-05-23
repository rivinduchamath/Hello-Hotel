package lk.sliit.employeeManagement.controller.indexController;

import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class  IndexController { //index.jsp Page Controller
@Autowired
IndexLoginBO indexLoginBO;

@GetMapping("/")
public String loginPage(){
    return "index";
}
    @GetMapping("login")
    public String loginPage1(){
        return "index";
    }
}//End class
