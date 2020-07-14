package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.employeeManagement.dto.inventory.SupplierDTO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class SupplierManage {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    InventoryBO inventoryBO;

    @GetMapping("/manageSupplier")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            SupplierDTO totalCount = inventoryBO.findTopByOrderBySupplierIdDesc ( );
            int x = Integer.parseInt ( totalCount.getId ( ) )+ 1;
            model.addAttribute ( "genId", x);
        } catch (NullPointerException e) {
            model.addAttribute ( "genId", 1 );
        }
        List<SupplierDTO> p = inventoryBO.findAllSuppliers();
        model.addAttribute("loadSupplier", p);
        return "manageSupplier";
    }

    @PostMapping("saveSupplier")
    public String itemTypeSave(@ModelAttribute SupplierDTO supplierDTO) {
         supplierDTO.setSubmittedBy(SuperController.idNo);
        inventoryBO.saveSupplier(supplierDTO);
        return "redirect:/manageSupplier";
    }
    @RequestMapping(value = "deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") String userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
      try {
          inventoryBO.deleteSupplier(userId);
      }catch (Exception e){

      }
        return "redirect:/manageSupplier";
    }


}
