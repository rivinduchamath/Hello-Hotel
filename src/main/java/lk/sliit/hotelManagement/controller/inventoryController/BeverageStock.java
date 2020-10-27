package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryOrderDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BeverageStock {
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/beverageStock")
    public String kitchenStock(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<InventoryDTO> p3 = inventoryBO.findStockData("Beverage");
        model.addAttribute("listAllBeverageStock", p3);
        List<InventoryNoticeDTO> p = inventoryBO.stockOrderNotices("Beverage");
        model.addAttribute("listBeverageNotice", p);
        List<InventoryOrderDTO> p1 = inventoryBO.loadTodayInventoryOrders();
        model.addAttribute("listTodayOrders", p1);
        return "beverageStock";
    }
}
