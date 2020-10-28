package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable.CounterTableReservationDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class RestaurantTableController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    RestaurantBO restaurantBO;

    @GetMapping("/restaurantTable")//Load Laundry Table
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<RestaurantTableDTO> tableList = restaurantBO.findAllTable();
        model.addAttribute("loadAllTablesTable", tableList);
        return "restaurantTable";
    }

    @PostMapping("/saveTable")
    public String addNewTable(Model model, @ModelAttribute RestaurantTableDTO restaurantTableDTO) {
         try {
            RestaurantTableDTO tableDTO1 = restaurantBO.findHighestTableId();//Find highest Id
            RestaurantTableDTO tableDTO2 = null;
            try {
                tableDTO2 = restaurantBO.findTableById(restaurantTableDTO.getTableId());//find One
            } catch (NullPointerException d) {
                int maxId = (tableDTO1.getTableId());
                if (restaurantTableDTO.getTableId() == (maxId)) {//Update
                    restaurantTableDTO.setTableId((maxId));
                } else {//New Table
                    maxId++;
                    restaurantTableDTO.setTableId((maxId));
                }
            }

        } catch (NullPointerException e) {//Initial Round
            restaurantTableDTO.setTableId(1);
        }

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        restaurantBO.saveTable(restaurantTableDTO);//Save Table
        return "redirect:/restaurantTable";
    }

    @GetMapping(value = "deleteTable/{tableId}")//Delete Table
    public void deleteTable(@PathVariable("tableId") int tableId, HttpServletResponse response) {
        restaurantBO.deleteTable(tableId);
        try {
            response.sendRedirect("/restaurantTable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/restaurantTableIndex")
    public String restaurantTableIndex(Model model) {//Find Today Booked Tables
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<CounterTableReservationDTO> p2 = restaurantBO.getBookedTables();
        model.addAttribute("todayBookedTables", p2);
        return "restaurantTableIndex";
    }

    @GetMapping("/restaurantTableReservation")
    public String restaurantTableReservation(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurantTableReservation";
    }


    @GetMapping("/counterTableDetails")//Find Available Tables
    public String checkTimeForTable(@ModelAttribute CounterTableReservationDTO counterTableReservationDTO,
                                    Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        Time a = Time.valueOf(counterTableReservationDTO.getvStatT()+":00");//convert time to Time type
        Time a2 = Time.valueOf(counterTableReservationDTO.getvEndT()+":00");
        counterTableReservationDTO.setStartTime(a);//Time set to dto
        counterTableReservationDTO.setEndTime(a2);
        Date date = Date.valueOf(counterTableReservationDTO.getvDate());//Set Date
        counterTableReservationDTO.setDate(date);
        model.addAttribute("reservedDate", (counterTableReservationDTO.getDate()));//Set Values to next Page
        model.addAttribute("timeIn", (counterTableReservationDTO.getStartTime()));
        model.addAttribute("timeOut", (counterTableReservationDTO.getEndTime()));
        List<RestaurantTableDTO> p2 =restaurantBO.getAviTables(counterTableReservationDTO.getDate(),//Find available
                counterTableReservationDTO.getStartTime(),counterTableReservationDTO.getEndTime());
        model.addAttribute("loadAllTable", p2);
        return "counterTableDetails";
    }

    @PostMapping("/saveCounterTable")//SAve Table in counter Table Reservations
    public String saveOnlineTable(@ModelAttribute CounterTableReservationDTO onlineOrderDTO, HttpSession session) {

        try {
            Time a = Time.valueOf(onlineOrderDTO.getvStatT());//Get time and
            Time a2 = Time.valueOf(onlineOrderDTO.getvEndT());
            onlineOrderDTO.setStartTime(a);// set time to time type
            onlineOrderDTO.setEndTime(a2);
            Date date = Date.valueOf(onlineOrderDTO.getvDate());
            onlineOrderDTO.setDate(date);
        }catch (IllegalArgumentException s){}
        try {
            //find highest Id
             CounterTableReservationDTO top = restaurantBO.findHighestCounterTableId();
            int x = (top.getCounterTableReserveId()) + 1;
            onlineOrderDTO.setCounterTableReserveId((x));
        } catch (NullPointerException e) {//If not found any Id

            onlineOrderDTO.setCounterTableReserveId((1));
        }
        try {
             restaurantBO.saveCounterTableId(onlineOrderDTO);//SAve
        } catch (NullPointerException d) {
            return "redirect:/restaurantTableReservation";
        }
        return "redirect:/restaurantTableReservation";
    }

}
