package lk.sliit.hotelManagement.controller.manageController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.hr.DepartmentDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryOrderDTO;
import lk.sliit.hotelManagement.dto.reservation.ReservationDTO;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManageDailyActivityReportController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @GetMapping("/manageDailyActivityReport")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));


        List<ReservationDTO> hotelRoomDTOList  =  houseKeepingBO.findAllTodayBill();//Find reservation Details
        model.addAttribute("loadHotelRoomTable", hotelRoomDTOList);
        List<InventoryOrderDTO> inventoryBill  =  inventoryBO.findInventoryBillToday();
        model.addAttribute("loadInventoryBills", inventoryBill);
        return "manageDailyActivityReport";
    }
}
