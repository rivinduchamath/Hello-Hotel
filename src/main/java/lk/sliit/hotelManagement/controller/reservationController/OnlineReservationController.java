package lk.sliit.hotelManagement.controller.reservationController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnlineReservationController {

    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/onlineReservation")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "onlineReservation";
        }

    @GetMapping("/roomSelection")
    public String loginPage1(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "roomSelection";
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
    public String loginPage8(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "onlineBooking";
    }

    }

