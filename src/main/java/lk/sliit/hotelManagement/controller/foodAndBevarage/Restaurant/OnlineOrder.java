package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OnlineOrder {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    OnlineCustomerBO onlineCustomerBO;
    @GetMapping("/onlineOrder")
    public String loadForm_validationSaveMode(Model model, HttpSession session) {
        try {
            String onlineCustomerId = session.getAttribute("userId").toString();
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (NullPointerException d) {
            return "onlineOrder";
        }
        return "onlineOrder";

    }
}