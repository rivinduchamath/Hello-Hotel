package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OnlineDashboard {
    @Autowired
    IndexLoginBO indexLoginBO;
    @RequestMapping("/onlineDashboard")
    public String registerUser( Model model) {
        //True If Id and password is match
            return "redirect:/onlineCustomer";
    }
}
