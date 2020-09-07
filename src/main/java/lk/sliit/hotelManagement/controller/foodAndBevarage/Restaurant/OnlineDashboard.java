package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OnlineDashboard {
    @Autowired
    IndexLoginBO indexLoginBO;
    @RequestMapping("/onlineDashboard")
    public String registerUser(@ModelAttribute OnlineCustomerDTO onlineCustomer, Model model) {
        //True If Id and password is match
        if (indexLoginBO.findByUserNameAndPassword(onlineCustomer.getUserName(), onlineCustomer.getPassword()) != null) {
            return "/onlineDashboard";
        } else {//If User name And Password is not match
            return "redirect:/onlineCustomer";
        }
    }
}
