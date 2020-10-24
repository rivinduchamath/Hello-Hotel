package lk.sliit.hotelManagement.controller.reservationController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerAdd {
    @Autowired
    ReservationBO reservationBO;
    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/customerRegistration")
    public String attendance(Model model) {
        List<CustomerDTO> list = reservationBO.findAll();
        model.addAttribute("loadReservationCustomer",list);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

            return "customerRegistration";
    }

    @PostMapping("/customerSignUp")
    public String saveOnlineCustomer(@ModelAttribute CustomerDTO customerDTO){
        try {
            CustomerDTO top = reservationBO.findHighestOnlineCustomerId();
            int x = (top.getOnlineCustomerId()) + 1;
            onlineCustomerDTO.setOnlineCustomerId((x));
        } catch (NullPointerException e) {
            onlineCustomerDTO.setOnlineCustomerId((1));
        }
        reservationBO.savecustomer(customerDTO);

        return "redirect:/customerLogin";
    }


    @GetMapping("/counterReservation")
    public String counterReservation(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        return "counterReservation";
    }


    @PostMapping("/saveOverTheCounterCustomer")
    public String saveOverTheCounterCustomer(@ModelAttribute CustomerDTO customerDTO){
        reservationBO.savecustomer(customerDTO);

        return "customerRegistration";
    }

    @GetMapping(value = "/deleteCustomer/{customerId}")
    public String deleteCustpomer(@PathVariable int customerId){
      reservationBO.deleteCustomer(customerId);
    return "customerRegistration";
    }
}
