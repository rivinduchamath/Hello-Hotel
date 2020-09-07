package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
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

            System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
            OnlineCustomerDTO onlineCustomer = onlineCustomerBO.findHighestOnlineCustomerId();
            System.out.println(onlineCustomer.getOnlineCustomerId()+"sssssssssssssssssssssssssssssssssssssssssssssssssssssss");
            int maxId = Integer.parseInt(onlineCustomer.getOnlineCustomerId());
            if (onlineCustomerDTO.getOnlineCustomerId().equals(String.valueOf(maxId))){
                onlineCustomerDTO.setOnlineCustomerId(String.valueOf(maxId));
            } else {
                maxId++;
                onlineCustomerDTO.setOnlineCustomerId(String.valueOf(maxId));
            }

        } catch (NullPointerException e){
            onlineCustomerDTO.setOnlineCustomerId("1");
        }
        onlineCustomerBO.saveOnlineCustomer(onlineCustomerDTO);
        return "redirect:/onlineCustomer";
    }

}
