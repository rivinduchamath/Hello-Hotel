package lk.sliit.employeeManagement.controller.houseKeepingController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.service.custom.HouseKeepingBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HouseKeepingController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;


    //Load Dashboard Page
    @GetMapping("/housekeeping")
    public String housekeeping(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "housekeeping";
    }

    //Load Room Crud Page
    @GetMapping("/manageRooms")
    public String manageRooms(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "manageRooms";
    }
}
