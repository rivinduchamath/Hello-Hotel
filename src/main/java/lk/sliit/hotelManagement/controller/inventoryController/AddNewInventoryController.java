package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddNewInventoryController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    InventoryBO inventoryBO;


    @GetMapping("/addInventoryType")//Add New Department in inventory
    public String loadForm_validationSaveMode(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_UPDATE");
        List<ItemTypeDTO> p = inventoryBO.findAll();
        model.addAttribute("loadItemType", p);
        //Top Id
        try {
            ItemTypeDTO totalCount = inventoryBO.findTopByOrderByIdDesc();
            int x = totalCount.getId() + 1;
            model.addAttribute("genId", x);
        } catch (NullPointerException e) {
            model.addAttribute("genId", 1);
        }
        return "addInventory";
    }

    @PostMapping("itemTypeSave")//Save inventort Department
    public String departmentSave(@ModelAttribute ItemTypeDTO inventoryDTO, HttpServletRequest request) {
        request.setAttribute("mode", "MODE_UPDATE");

        List<ItemTypeDTO> p1 = inventoryBO.findInventoryDepartment();
        for (ItemTypeDTO itemTypeDTO : p1) {
            if (itemTypeDTO.getUserType().equals(inventoryDTO.getUserType())) {
                return "redirect:/addInventoryType";
            }
        }
        inventoryDTO.setSubmittedBy(SuperController.idNo);
        inventoryBO.saveInventoryType(inventoryDTO);
        return "redirect:/addInventoryType";
    }

    @RequestMapping(value = "deleteInventoryItem/{id}")//delete Department
    public String deleteDepartment(@PathVariable("id") int id) {

        try {
            inventoryBO.deleteInventoryType(id);
        } catch (Exception e) {
        }
        return "redirect:/addInventoryType";
    }

    @RequestMapping("/allInventoryNotice")//Load All Inventory notice
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

    @PostMapping("inventoryItemSave")//SAve Inventory Item
    public String saveForm(@ModelAttribute InventoryDTO inventoryDTO) {

        try {
            InventoryDTO itemTypeDTO = inventoryBO.findHighestId();//Id generate
             InventoryDTO inventoryDTO1 = null;
            try {
                inventoryDTO1 = inventoryBO.findFoodItemById(inventoryDTO.getInventoryId());
            } catch (NullPointerException d) {
                int maxId = (itemTypeDTO.getInventoryId());
                if (inventoryDTO.getInventoryId() == (maxId)) {
                    inventoryDTO.setInventoryId((maxId));
                } else {
                    maxId++;
                    inventoryDTO.setInventoryId((maxId));
                }
            }
        } catch (NullPointerException e) {
            inventoryDTO.setInventoryId(1);
        }
        inventoryBO.saveInventoryItem(inventoryDTO);
        return "redirect:/addInventory";
    }


    @RequestMapping(value = "deleteInventory/{inventoryId}")//Delete Inventory
    public String deleteNotice(@PathVariable("inventoryId") int inventoryId) {

        try {
            inventoryBO.deleteInventoryNotice(inventoryId);
        } catch (Exception e) {
        }
        return "redirect:/addInventory";
    }

    @GetMapping("/addInventory")//Load Add Inventory Page
    public String loginPage(Model model, HttpServletRequest request) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_REGISTER");
        List<ItemTypeDTO> p = inventoryBO.findAll();//Load Department type
        model.addAttribute("loadItemType", p);
        List<InventoryDTO> p1 = inventoryBO.findAllInventory();//Load Items
        model.addAttribute("loadInventoryItemTable", p1);

        return "addInventory";
    }


}
