package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.dto.timeCheckDTO;
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
import java.sql.Date;
import java.sql.Time;
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
            int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (Exception d) {
            return "onlineTable";
        }
        return "onlineTable";
    }

    @GetMapping("/onlineTableDetails")
    public String onlineTableDetails(Model model, HttpServletRequest request) {

        List<RestaurantTableDTO> p1 = restaurantBO.findAllTable();
        model.addAttribute("loadAllTables", p1);
        return "onlineTableDetails";
    }

    @GetMapping("/checkTimeForTable")
    public String checkTimeForTable(@ModelAttribute OnlineTableReservationDTO onlineTable, Model model, HttpSession session) {
        Time a = Time.valueOf(onlineTable.getvStatT()+":00");
        Time a2 = Time.valueOf(onlineTable.getvEndT()+":00");
        onlineTable.setStartTime(a);
        onlineTable.setEndTime(a2);
        Date date =Date.valueOf(onlineTable.getvDate());
        onlineTable.setReservedDate(date);
        List<RestaurantTableDTO> p2 =restaurantBO.getAviTables(onlineTable.getReservedDate(),onlineTable.getStartTime(),onlineTable.getEndTime());
        model.addAttribute("loadAllTables", p2);
        try {
            int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
        } catch (NullPointerException d) {
            return "onlineTableDetails";
        }
        return "onlineTableDetails";
    }


}
