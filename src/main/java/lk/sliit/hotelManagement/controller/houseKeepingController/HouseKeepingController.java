package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    //Load Room Crud Page
    @GetMapping("/roomService")
    public String roomService(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "roomService";
    }
}
