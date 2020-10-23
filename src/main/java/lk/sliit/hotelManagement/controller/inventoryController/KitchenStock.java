package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class KitchenStock {
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/kitchenStock")
    public String kitchenStock(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<InventoryDTO> p3 = inventoryBO.findKitchenStockData();
        model.addAttribute("listAllKitchenStock", p3);
        List<InventoryNoticeDTO> p = inventoryBO.kitchenOrderNotices();
        model.addAttribute("listKitchenNotice", p);

        return "kitchenStock";
    }
}
//      List<InventoryDTO> p = inventoryBO.findKitchenStockData();
//        model.addAttribute("listAllKitchenStock", p);
