package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Scope;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OnlineCustomer {

    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    OnlineCustomerBO onlineCustomerBO;


    @GetMapping("/onlineCustomer")
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request) {
        return "onlineCustomer";
    }

    @PostMapping("/onlineCustomerSave")
    public String saveForm(@ModelAttribute OnlineCustomerDTO onlineCustomerDTO) {

        try {
            OnlineCustomerDTO top = onlineCustomerBO.findHighestOnlineCustomerId();
            int x = Integer.parseInt(top.getOnlineCustomerId()) + 1;
            onlineCustomerDTO.setOnlineCustomerId(String.valueOf(x));
        } catch (NullPointerException e) {
            onlineCustomerDTO.setOnlineCustomerId(String.valueOf(1));
        }

        onlineCustomerBO.saveOnlineCustomer(onlineCustomerDTO);
        return "redirect:/onlineCustomer";
    }


    @PostMapping("/onlineSignIn")
    public String onlineTableDetails(@ModelAttribute OnlineCustomerDTO onlineCustomer, Model model, HttpServletRequest request) {
        try {
            OnlineCustomerDTO onlineCustomerDTO = onlineCustomerBO.findByUserNameAndPassword(onlineCustomer.getUserName(), onlineCustomer.getPassword());
            if (onlineCustomerDTO != null) {
                request.getSession().setAttribute("userId", onlineCustomerDTO.getOnlineCustomerId());
                return "redirect:/onlineDashboard";
            } else {//If User name And Password is not match
                return "redirect:/onlineCustomer";
            }
        } catch (NullPointerException e) {
            return "redirect:/onlineCustomer";
        }

    }

    @RequestMapping("/onlineDashboard")
    public String registerUser(Model model, HttpSession session) {
        try {
            String onlineCustomerId = session.getAttribute("userId").toString();
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (NullPointerException d) {
            return "onlineDashboard";
        }
        return "onlineDashboard";
    }


}
