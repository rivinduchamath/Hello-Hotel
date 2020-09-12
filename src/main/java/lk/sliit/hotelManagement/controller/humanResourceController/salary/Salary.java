package lk.sliit.hotelManagement.controller.humanResourceController.salary;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ManageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Salary {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ManageBO manageBO;
    @GetMapping("/salary")
    public String salary(Model model) {
        List<EmployeeDTO> p = manageBO.findAllUser();
        model.addAttribute("loadAllUsers", p);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "salary";
    }
}
