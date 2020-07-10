package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.employeeManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.employeeManagement.service.custom.BarBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class AddNewInventoryController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    InventoryBO inventoryBO;


    @RequestMapping("/addInventoryType")
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_UPDATE");

        return "addInventory";
    }

    @RequestMapping("/allInventoryNotice")
    public String allInventoryNotice(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_WATCH");
        List<InventoryNoticeDTO> p1 = inventoryBO.findAllInventoryNotice();
        model.addAttribute("loadInventoryNoticeItemTable", p1);
        return "addInventory";
    }

    //Update  Quantity in Table Input Field Change Quantity On Hand
    @RequestMapping(value = "/updateQtyToday1")
    public String updateQtyToday(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            //Get Inventory Data From Inventory Id
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            //Add New Qty To Current Qty On Hand
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            //Update InventoryDTO1
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/allInventoryNotice";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/allInventoryNotice";
    }//End Update Qty On Hand Find All Notice

    @PostMapping("inventoryItemSave")
    public String saveForm(@ModelAttribute InventoryDTO inventoryDTO) {
        inventoryBO.saveInventoryItem(inventoryDTO);
        return "redirect:/addInventory";
    }


    @RequestMapping(value = "deleteInventory/{inventoryId}")
    public String deleteNotice(@PathVariable("inventoryId") String inventoryId) {

        try {
            inventoryBO.deleteInventoryNotice(inventoryId);
        } catch (Exception e) {
        }
        return "redirect:/addInventory";
    }

    @GetMapping("/addInventory")
    public String loginPage(Model model, HttpServletRequest request) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_REGISTER");
        List<ItemTypeDTO> p = inventoryBO.findAll();
        model.addAttribute("loadItemType", p);
        List<InventoryDTO> p1 = inventoryBO.findAllInventory();
        model.addAttribute("loadInventoryItemTable", p1);

        return "addInventory";
    }


}
