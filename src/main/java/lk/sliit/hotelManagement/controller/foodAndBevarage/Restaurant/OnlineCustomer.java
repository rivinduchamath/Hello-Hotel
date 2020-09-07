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

import javax.servlet.http.HttpServletRequest;

@Controller
public class OnlineCustomer {

    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    OnlineCustomerBO onlineCustomerBO;



    @GetMapping("/onlineCustomer")
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "onlineCustomer";
    }

    @PostMapping("/onlineCustomerSave")
    public String saveForm(@ModelAttribute OnlineCustomerDTO onlineCustomerDTO){

        try {
            OnlineCustomerDTO top = onlineCustomerBO.findHighestOnlineCustomerId ( );
            int x = Integer.parseInt ( top.getOnlineCustomerId ( ) )+ 1;
            onlineCustomerDTO.setOnlineCustomerId ( String.valueOf ( x ) );
        } catch (NullPointerException e) {
            onlineCustomerDTO.setOnlineCustomerId ( String.valueOf ( 1 ) );
        }

        onlineCustomerBO.saveOnlineCustomer(onlineCustomerDTO);
        return "redirect:/onlineCustomer";
    }


}
