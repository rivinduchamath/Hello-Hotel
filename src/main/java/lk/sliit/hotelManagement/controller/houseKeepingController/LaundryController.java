package lk.sliit.hotelManagement.controller.houseKeepingController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
public class LaundryController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;

    //*************************************** Laundry Manage Dashboard  ***********************************
    //Load Dashboard Page
    @GetMapping("/laundryOrder")
    public String housekeeping(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //Load Customer Table
        List<CustomerDTO> customerDTOS = houseKeepingBO.findCustomers();
        model.addAttribute("customerAllIn", customerDTOS);

        //Processing data
        List<LaundryDTO> viewProcessing = houseKeepingBO.findFinishedLaundryData();
        model.addAttribute("viewProcessing", viewProcessing);

        return "laundryOrder";
    }

    //Delete Accept Orders
    @GetMapping(value = "deleteLaundryOrder3/{laundryId}")
    public void deleteLaundry(@PathVariable("laundryId") int id, HttpServletResponse response) throws IOException {

        houseKeepingBO.deleteLaundryOrder(id);
        response.sendRedirect("/laundryOrder");

    }

    //Save Or Update Laundry Orders
    @PostMapping("/laundryOrder")
    public ModelAndView saveForLaundry(@ModelAttribute LaundryDTO laundryDTO, Model model, HttpServletRequest request) {

        ModelAndView a = new ModelAndView("laundryOrder");//  load Page laundry Order

        List<LaundryDTO> viewProcessing = houseKeepingBO.findProcessingLaundryData();    //Processing data
        model.addAttribute("viewProcessing", viewProcessing);

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<CustomerDTO> customerDTOS = houseKeepingBO.findCustomers(); //Load Customer Table
        a.addObject("customerAllIn", customerDTOS);

        if (laundryDTO.getCustomerId() == 0) { // If Customer Id equal 0
            request.setAttribute("notSelectCustomer", "True");
            return a;
        }
        try {
            LaundryDTO laundryDTO2 = houseKeepingBO.findHighestId();
            LaundryDTO laundryDTO1 = null;
            try {
                laundryDTO1 = houseKeepingBO.findLaundryOrderById(laundryDTO.getLaundryId());
            } catch (NullPointerException d) {
                int maxId = (laundryDTO2.getLaundryId());
                if (laundryDTO.getLaundryId() == (maxId)) {
                    laundryDTO.setLaundryId((maxId));
                } else {
                    maxId++;
                    laundryDTO.setLaundryId((maxId));
                }
            }
        } catch (NullPointerException e) {
            laundryDTO.setLaundryId(1); //If not find any data in DB
        }

        laundryDTO.setOrderHolder(SuperController.idNo);// Order Holder
        houseKeepingBO.saveLaundry(laundryDTO);

        return a;
    }

    @GetMapping("/allLaundryOrders")
    public String allLaundryOrders(Model model) {
        List<LaundryDTO> laundryDTOS = houseKeepingBO.findLaundryData();
        model.addAttribute("viewAcceptedOrders", laundryDTOS);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<CustomerDTO> customerDTOS = houseKeepingBO.findCustomers();
        model.addAttribute("customerAllIn", customerDTOS);

        return "allLaundryOrders";
    }

    @GetMapping(value = "deleteLaundryOrder/{laundryId}")
    public void deleteLaundr2(@PathVariable("laundryId") int id, HttpServletResponse response) throws IOException {

        houseKeepingBO.deleteLaundryOrder(id);
        response.sendRedirect("/allLaundryOrders");

    }

    //Change State In Laundry Orders
    @GetMapping(value = "processLaundryOrder/{laundryId}")
    public void processLaundryOrder(@PathVariable("laundryId") int id, HttpServletResponse response) throws IOException {

        houseKeepingBO.changeState(id);
        response.sendRedirect("/allLaundryOrders");

    }

}





