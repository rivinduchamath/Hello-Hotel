package lk.sliit.hotelManagement.controller.humanResourceController.roomsHRController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class roomsHRController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;


    @GetMapping("/roomsHR")
    public String roomsHR(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOList = houseKeepingBO.findRooms();
        model.addAttribute("loadRoomTable", hotelRoomDTOList);
        return "roomsHR";
    }

    @PostMapping("/updateRoomHR")
    public String updateRoomHR(@ModelAttribute HotelRoomDTO hotelRoomDTO, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        hotelRoomDTO.setHolder(SuperController.idNo);
        HotelRoomDTO hotelRoomDTO1 = null;
        try {
            hotelRoomDTO1 = houseKeepingBO.findRoomIdByID(hotelRoomDTO.getRoomId2());
            hotelRoomDTO.setDate(hotelRoomDTO1.getDate());
            hotelRoomDTO.setStatus(hotelRoomDTO1.getStatus());
            hotelRoomDTO.setRoomType(hotelRoomDTO1.getType());
        }catch (NullPointerException d){
            return "redirect:/roomsHR";
        }
        humanResourceBO.updateRoomHR(hotelRoomDTO);
        return "redirect:/roomsHR";
    }
}
