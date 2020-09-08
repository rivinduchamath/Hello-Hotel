package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    //add rooms
    @PostMapping("/manageRoomSave")
    public String saveformRooms(@ModelAttribute HotelRoomDTO hotelRoomDTO ){
        System.out.println("sssssssssssssssssssssssssssssssssss");
        houseKeepingBO.saveRoomDetails(hotelRoomDTO);
        System.out.println("sssssssssssssssssssssssssssssssssss");
        return "redirect:/manageRooms";
    }


    //Load Room Crud Page
    @GetMapping("/roomService")
    public String roomService(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "roomService";
    }    @GetMapping("/houseKeepingReport")
    public String houseKeepingReport(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "houseKeepingReport";
    }
}
