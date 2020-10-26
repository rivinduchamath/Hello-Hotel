package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class OnlineContact {
    @Autowired
    OnlineCustomerBO onlineCustomerBO;
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/onlineContact")
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request,HttpSession session) {
        try {
            model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
            int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
            model.addAttribute("loggersId", onlineCustomerBO.findOne(onlineCustomerId));
            return "onlineContact";
        } catch (Exception e) {
            return "onlineContact";
        }
    }
}
