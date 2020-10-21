package lk.sliit.hotelManagement.controller.reservationController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable.CounterTableReservationDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class OnlineReservationController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ReservationBO reservationBO;

    @GetMapping("/onlineReservation")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "onlineReservation";
    }



    @GetMapping("/onlineBooking")
    public String saveOnlineTable(Model model,@ModelAttribute FindAvailabilityDTO findAvailabilityDTO, HttpSession session) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOS = reservationBO.findAvilability(findAvailabilityDTO);
        model.addAttribute("loadAllTable", hotelRoomDTOS);
        return "redirect:/onlineReservation";
    }

}

