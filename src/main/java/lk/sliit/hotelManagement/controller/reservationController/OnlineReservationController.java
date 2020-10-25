package lk.sliit.hotelManagement.controller.reservationController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OnlineReservationController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    ReservationBO reservationBO;


    @GetMapping("/home")
    public String loginPage1(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "home";
        }

    @GetMapping("/about")
    public String loginPage2(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "about";
    }

    @GetMapping("/contact")
    public String loginPage3(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "contact";
    }

    @GetMapping("/dinning")
    public String loginPage4(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "dinning";
    }

    @GetMapping("/gallery")
    public String loginPage5(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "gallery";
    }

    @GetMapping("/news")
    public String loginPage6(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "news";
    }

    @GetMapping("/rooms")
    public String loginPage7(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "rooms";
    }

    @GetMapping("/onlineBooking")
    public String saveOnlineTable(Model model,@ModelAttribute FindAvailabilityDTO findAvailabilityDTO, HttpSession session) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOS = reservationBO.findAvilability(findAvailabilityDTO);
        model.addAttribute("loadAllTable", hotelRoomDTOS);
        return "onlineBooking";
    }





    @GetMapping("/availableRooms")
    public String saveTable4(Model model,@ModelAttribute FindAvailabilityDTO findAvailabilityDTO, HttpSession session) {
        try {
            int onlineCustomerId = Integer.parseInt(session.getAttribute("CustomerId").toString());
            model.addAttribute("loggedCustomer", reservationBO.findId(onlineCustomerId));
        } catch (Exception d) {
            return "availableRooms";
        }
        model.addAttribute("checkIn", (findAvailabilityDTO.getCheckIn()));
        model.addAttribute("checkOut", (findAvailabilityDTO.getCheckOut()));
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOS = reservationBO.findAvilability(findAvailabilityDTO);
        model.addAttribute("loadAllTable", hotelRoomDTOS);
        return "availableRooms";
    }


    @PostMapping("/saveOnlineRooms")
    public String onlineCustomerDetails(@ModelAttribute CustomerDTO customerDTO, Model model, HttpServletRequest request) {
        try {
            CustomerDTO customerDTO1 = reservationBO.findByUserNameAndPassword(customerDTO.getEmail(), customerDTO.getPassword());
            if (customerDTO1 != null) {
                request.getSession().setAttribute("CustomerId", customerDTO1.getCustomerId());
                return "redirect:/roomTypes";
            } else {
                return "redirect:/customerLogin";
            }
        } catch (NullPointerException e) {
            return "redirect:/customerLogin";
        }

    }


}

