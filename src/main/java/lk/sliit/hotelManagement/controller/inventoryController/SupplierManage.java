package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.SupplierDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SupplierManage {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    InventoryBO inventoryBO;

    @GetMapping("/manageSupplier")//Load Page
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        SupplierDTO supplierDTO = new SupplierDTO();
        model.addAttribute("supplierDTO", supplierDTO);
        try {
            SupplierDTO totalCount = inventoryBO.findTopByOrderBySupplierIdDesc ( );//Auto generate id
            int x = ( totalCount.getId ( ) )+ 1;
            model.addAttribute ( "genId", x);
        } catch (NullPointerException e) {
            model.addAttribute ( "genId", 1 );
        }
        List<SupplierDTO> p = inventoryBO.findAllSuppliers();
        model.addAttribute("loadSupplier", p);
        return "manageSupplier";
    }

    @PostMapping("saveSupplier")                                            //SAve Supplier
    public String itemTypeSave(@ModelAttribute SupplierDTO supplierDTO) {
        supplierDTO.setSubmittedBy(SuperController.idNo);
        inventoryBO.saveSupplier(supplierDTO);
        return "redirect:/manageSupplier";
    }
    @RequestMapping(value = "deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable("id") int userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            inventoryBO.deleteSupplier(userId);
        }catch (Exception e){

        }
        return "redirect:/manageSupplier";
    }


}
