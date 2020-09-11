package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        List<HotelRoomDTO> hotelRoomDTOList  = houseKeepingBO.findRooms();
        model.addAttribute("loadHotelRoomTable", hotelRoomDTOList);
        return "/manageRooms";
    }

    //add rooms
    @PostMapping("/manageRoomSave")
    public String saveFormRooms( @ModelAttribute HotelRoomDTO hotelRoomDTO,Model model ){
         model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            hotelRoomDTO.setRoomId2(Integer.parseInt(hotelRoomDTO.getGetRoomId2()));
        }catch (NumberFormatException e){

        }
         try {
            HotelRoomDTO hotelRoom = houseKeepingBO.findHighestRoomId();
            HotelRoomDTO hotelRoomDTO1 = null;
            try {
                hotelRoomDTO1 = houseKeepingBO.findRoomIdByID(hotelRoomDTO.getRoomId2());
            }catch (NullPointerException d){
                int maxId = (hotelRoom.getRoomId2());
                if (hotelRoomDTO.getRoomId2()==((maxId))) {
                    hotelRoomDTO.setRoomId2((maxId));
                } else {
                    maxId++;
                    hotelRoomDTO.setRoomId2((maxId));
                }
            }

        } catch (NullPointerException e){
               hotelRoomDTO.setRoomId2(1);
        }
        houseKeepingBO.saveRoomDetails(hotelRoomDTO);
        return "redirect:/manageRooms";
    }

    @GetMapping(value = "/roomDelete/{roomId}")
    public void deleteRoom(Model model, @PathVariable("roomId") int roomId, HttpServletResponse response){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        houseKeepingBO.deleteRoomDetails(roomId);
        try {
            response.sendRedirect("/manageRooms");
        } catch (IOException e){

        }
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
