package lk.sliit.hotelManagement.controller.reservationController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @GetMapping("/customerLogin")
    public String saveOnlineTable2(Model model, @ModelAttribute FindAvailabilityDTO findAvailabilityDTO, HttpSession session) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "customerLogin";
    }
    @PostMapping("/customerSignUp")
    public String saveOnlineCustomer(@ModelAttribute CustomerDTO customerDTO){
        try {
            CustomerDTO top = reservationBO.findId(customerDTO.getCustomerId());

        } catch (NullPointerException e) {
            reservationBO.saveOnlineCustomer(customerDTO);
        }
        return "redirect:/customerLogin";
    }
    @PostMapping("/customerSignIn")
    public String onlineCustomerDetails(@ModelAttribute CustomerDTO customerDTO, Model model, HttpServletRequest request) {
        try {
            CustomerDTO customerDTO1 = reservationBO.findByUserNameAndPassword(customerDTO.getCustomerId(), customerDTO.getPassword());
            if (customerDTO1 != null) {
                request.getSession().setAttribute("CustomerId", customerDTO1.getCustomerId());
                return "redirect:/onlineReservation";
            } else {
                return "redirect:/customerLogin";
            }
        } catch (NullPointerException e) {
            return "redirect:/customerLogin";
        }

    }
    @GetMapping("/onlineReservation")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "onlineReservation";
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
