package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.hr.AttendanceDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.GetDateHouseKeepingDTO;
import lk.sliit.hotelManagement.dto.reservation.ReservationDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HouseKeepingController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;
//*************************************** House Keeping Dashboard *************************************
    //Load HouseKeeping Dashboard Page
    @GetMapping("/housekeeping")
    public String housekeeping(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //Find Not Cleaned Rooms
        List<HotelRoomDTO> hotelRoomDTOList  = houseKeepingBO.findDirtyRooms("NotCleaned");

        //Today Attendance In HouseKeeping Department
        ArrayList<AttendanceDTO> todayCleanAttendance  = new ArrayList<>();
        int i =0;
        for (AttendanceDTO v:humanResourceBO.findTodayCleanAttendance ( )) {//Read Today Attendance

            if(v.getEmpDepartment().equals("HouseKeeping")){
                System.out.println("Cake "+v.getEmpDepartment());
                todayCleanAttendance.add(i,v);
              i++;
            }
        }
        model.addAttribute ( "todayCleanAttendance", todayCleanAttendance );
        model.addAttribute("loadAllDirtyRooms", hotelRoomDTOList);
        return "housekeeping";
    }
//*************************************** End Rooms Dashboard *************************************

//*************************************** Manage Rooms ********************************************

    //Load Room Crud Page
    @GetMapping("/manageRooms")
    public String manageRooms(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOList  = houseKeepingBO.findRooms(); //Find All Rooms
        model.addAttribute("loadHotelRoomTable", hotelRoomDTOList);
        return "/manageRooms";
    }

    //Save Or Update rooms
    @PostMapping("/manageRoomSave")
    public String saveFormRooms( @ModelAttribute HotelRoomDTO hotelRoomDTO,Model model ){
         model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
       hotelRoomDTO.setHolder(SuperController.idNo);
        try {
            hotelRoomDTO.setRoomId2(Integer.parseInt(hotelRoomDTO.getGetRoomId2())); // Find Enterd Id
        }catch (NumberFormatException e){

        }
         try {
            HotelRoomDTO hotelRoom = houseKeepingBO.findHighestRoomId(); // Find Highest Id in Database
            HotelRoomDTO hotelRoomDTO1 = null;
            try {
                hotelRoomDTO1 = houseKeepingBO.findRoomIdByID(hotelRoomDTO.getRoomId2()); // If Find Any Id (Update)
            }catch (NullPointerException d){ // Not Fount (Save)
                int maxId = (hotelRoom.getRoomId2());
                if (hotelRoomDTO.getRoomId2()==((maxId))) {
                    hotelRoomDTO.setRoomId2((maxId));
                } else {
                    maxId++;        //Increment Id
                    hotelRoomDTO.setRoomId2((maxId));
                }
            }

        } catch (NullPointerException e){//If Cannot Find Highest Id (Initial Running)
               hotelRoomDTO.setRoomId2(1);//Set Id to 1
        }
        houseKeepingBO.saveRoomDetails(hotelRoomDTO); //Save Or Update Room
        return "redirect:/manageRooms";
    }

    @GetMapping(value = "/roomDelete/{roomId}") //Delete Room
    public String deleteRoom(Model model, @PathVariable("roomId") int roomId, HttpServletResponse response) throws IOException {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
        houseKeepingBO.deleteRoomDetails(roomId);

            return "redirect:/manageRooms";
        } catch (Exception e){

        }
       return "redirect:/manageRooms";
    }
//*************************************** End Manage Rooms *************************************


    //Load House Keeping Report
    @GetMapping("/houseKeepingReport")
    public String houseKeepingReport(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "houseKeepingReport";
    }
    //
    @PostMapping("/houseKeepingReport")
    public ModelAndView houseKeepingReports(@ModelAttribute GetDateHouseKeepingDTO getDateHouseKeepingDTO, Model model ){
        ModelAndView modelAndView = new ModelAndView("houseKeepingReport");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<ReservationDTO> hotelRoomDTOList  =  houseKeepingBO.findBill(getDateHouseKeepingDTO);//Find reservation Details
        model.addAttribute("loadHotelRoomTable", hotelRoomDTOList);

        return modelAndView;
    }

}
