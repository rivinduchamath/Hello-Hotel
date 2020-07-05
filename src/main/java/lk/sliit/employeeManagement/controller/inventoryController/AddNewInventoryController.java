package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.InventoryBO;
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

    @GetMapping("/addInventory")
    public String loginPage(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute ( "mode", "MODE_REGISTER" );
        List<ItemTypeDTO> p = inventoryBO.findAll();
        model.addAttribute("loadItemType", p);
        List<InventoryDTO> p1 = inventoryBO.findAllInventory();
        model.addAttribute("loadInventoryItemTable", p1);
         return "addInventory";
    }

    @RequestMapping("/addInventoryType")
    public String loadForm_validationSaveMode(Model model,HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute ( "mode", "MODE_UPDATE" );
        return "addInventory";
    }
    @PostMapping("inventoryItemSave")
    public String saveForm(@ModelAttribute InventoryDTO inventoryDTO) {
        inventoryBO.saveInventoryItem(inventoryDTO);
        return "redirect:/addInventory";
    }
   /* @RequestMapping(value = "/delete/{noticeId}")
    public String deleteNotice(@PathVariable String noticeId) {
        if(inventoryBO.findInventoryNotice(noticeId) != null){
            inventoryBO.deleteInventoryNotice(noticeId);
            return "redirect:/addInventory";
        }
        else{
            return  "Notice is not available ";
        }
    }*/
    @RequestMapping("delete")
    public String deleteNotice(@RequestParam String noticeId) {
        try {
            inventoryBO.deleteInventoryNotice(noticeId);
        }catch (Exception e){
            System.out.println ("Notice Id =" +noticeId+" Not Found" );
        }
        return "redirect:/addInventory";
    }
}
