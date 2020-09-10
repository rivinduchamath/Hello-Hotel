package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class OnlineTable {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    RestaurantBO restaurantBO;
    @Autowired
    OnlineCustomerBO onlineCustomerBO;
    @GetMapping("/onlineTable")
    public String loadForm_validationSaveMode(Model model,  HttpSession session,HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            String onlineCustomerId = session.getAttribute("userId").toString();
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
            System.out.println("Sttttttttttttttttttttttttt444444444444444444444ttttart");
        } catch (NullPointerException d) {
            return "onlineTable";
        }
        return "onlineTable";
    }

    @GetMapping("/onlineTableDetails")
    public String onlineTableDetails(Model model, HttpServletRequest request) {

        List<RestaurantTableDTO> p1 = restaurantBO.findAllTable();
        model.addAttribute("loadAllTables", p1);
        System.out.println("Sttttttttttttttttttttttttt444444444444444444444ttttart");
        return "onlineTableDetails";
    }

    @GetMapping("/checkTimeForTable")
    public String checkTimeForTable(@ModelAttribute OnlineTableReservationDTO onlineTable, Model model, HttpSession session) {
/*        Time a = Time.valueOf(onlineTable.getStartTime()+":00");
        Time a2 = Time.valueOf(onlineTable.getEndTime()+":00");
        onlineTable.setStartTime(a);
        onlineTable.setEndTime(a2);*/

        System.out.println("Sttttttttttttttttttttttttt444444444444444444444ttttart"+onlineTable.getReservedDate());

        List<RestaurantTableDTO> p1 = restaurantBO.findAllTableDateEqual(onlineTable.getReservedDate());
        for (RestaurantTableDTO r: p1){
            System.out.println(r+"rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        }
        model.addAttribute("loadAllTables", p1);

        System.out.println("Ennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnd");
        try {
            String onlineCustomerId = session.getAttribute("userId").toString();
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (NullPointerException d) {
            return "onlineTableDetails";
        }
        return "onlineTableDetails";
    }


}
