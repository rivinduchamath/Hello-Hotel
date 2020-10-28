package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.manager.MailDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerLocationsDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.MailSend;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Scope;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class OnlineCustomer {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    MailSend mailSend;
    @Autowired
    OnlineCustomerBO onlineCustomerBO;


    @GetMapping("/onlineCustomer")//Load Online Customer Page
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request) {
        List<OnlineCustomerLocationsDTO> tableList = onlineCustomerBO.findDeliveryLocation(); //Find Delivery
        model.addAttribute("loadLocationType", tableList);
        return "onlineCustomer";
    }

    @PostMapping("/onlineCustomerSave")//Save SignUp
    public String saveForm(@ModelAttribute OnlineCustomerDTO onlineCustomerDTO) {

        try {//Auto Generate Id
            OnlineCustomerDTO top = onlineCustomerBO.findHighestOnlineCustomerId();
            int x = (top.getOnlineCustomerId()) + 1;
            onlineCustomerDTO.setOnlineCustomerId((x));
        } catch (NullPointerException e) {
            onlineCustomerDTO.setOnlineCustomerId((1));
        }
//Save customer
        onlineCustomerBO.saveOnlineCustomer(onlineCustomerDTO);
        return "redirect:/onlineCustomer";
    }

//SignIn Page
    @PostMapping("/onlineSignIn")
    public String onlineTableDetails(@ModelAttribute OnlineCustomerDTO onlineCustomer, Model model, HttpServletRequest request) {
        try {
            //Check validations
            OnlineCustomerDTO onlineCustomerDTO = onlineCustomerBO.findByUserNameAndPassword(onlineCustomer.getUserName(), onlineCustomer.getPassword());
            if (onlineCustomerDTO != null) {
                //Show Logged User Name
                request.getSession().setAttribute("userId", onlineCustomerDTO.getOnlineCustomerId());
                return "redirect:/onlineDashboard";
            } else {//If User name And Password is not match
                return "redirect:/onlineCustomer";
            }
        } catch (NullPointerException e) {
            return "redirect:/onlineCustomer";
        }

    }

    @PostMapping("/sendMailFromOnline")//Send Mail from onlineContact Page
    public String sendMailFromOnline( @ModelAttribute MailDTO mailDTO, HttpSession session,Model model) {

        try {
            int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
            OnlineCustomerDTO onlineCustomerDTO = onlineCustomerBO.findOne(onlineCustomerId);//Find Customer From cookie
            mailDTO.setCustomerAddress(onlineCustomerDTO.getAddress());
            mailDTO.setCustomerName(onlineCustomerDTO.getName());
            mailDTO.setEmail(onlineCustomerDTO.getEmail());

            mailSend.sendMailToCustomer(mailDTO);
        } catch (Exception d) {
            return "redirect:/onlineContact";
        }
        return "redirect:/onlineContact";
    }


    @RequestMapping("/onlineDashboard")
    public String registerUser(Model model, HttpSession session) {
        try {
            int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (Exception d) {
            return "onlineDashboard";
        }
        return "onlineDashboard";
    }

    @GetMapping("/addLocation")//Add Location Page
    public String addCustomerLocations(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<OnlineCustomerLocationsDTO> tableList = onlineCustomerBO.findDeliveryLocation();
        model.addAttribute("loadDeliveryLocations", tableList);
        return "addLocation";
    }
    @GetMapping(value = "deleteLocation/{locationId}")//Delete location
    public void deleteTable(@PathVariable("locationId") int locationId, HttpServletResponse response) {
        onlineCustomerBO.deleteLocation(locationId);
        try {
            response.sendRedirect("/addLocation");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/saveLocation")
    public String addNewTable(Model model, @ModelAttribute OnlineCustomerLocationsDTO onlineCustomerLocationsDTO) {
        try {
            OnlineCustomerLocationsDTO tableDTO1 = onlineCustomerBO.findHighestOnlineLocationId();
            OnlineCustomerLocationsDTO tableDTO2 = null;
            try {//Generate Id
                tableDTO2 = onlineCustomerBO.findOnlineLocationbyId(onlineCustomerLocationsDTO.getLocationId());
            } catch (NullPointerException d) {
                int maxId = (tableDTO1.getLocationId());
                if (onlineCustomerLocationsDTO.getLocationId() == (maxId)) {
                    onlineCustomerLocationsDTO.setLocationId((maxId));
                } else {
                    maxId++;
                    onlineCustomerLocationsDTO.setLocationId((maxId));
                }
            }

        } catch (NullPointerException e) {
            onlineCustomerLocationsDTO.setLocationId(1);
        }

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        onlineCustomerBO.saveLocation(onlineCustomerLocationsDTO);
        return "redirect:/addLocation";
    }

}
