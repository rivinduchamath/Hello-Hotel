package lk.sliit.employeeManagement.controller.indexController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.EmployeeDTO;
import lk.sliit.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class IndexController { //index.jsp Page Controller
    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/")
    public String loginPage() {
        return "index";
    }

    @RequestMapping("login")
    public String loginPage1() {
        return "index";
    }

    @RequestMapping("Dashboard") // Load dashboard.jsp Page If Id And password is mach
    public String registerUser(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {
        //True If Id and password is match
        if (indexLoginBO.findByIdNoAndPassword(employee.getIdNo(), employee.getPassword()) != null) {

            //Add Logger Id To the static variable idNo
            SuperController.idNo = employee.getIdNo();
            //Get Logger Data
            model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

            return "/dashboard";
        } else {//If User name And Password is not match
            return "redirect:/login";
        }
    }//End method
}//End class
