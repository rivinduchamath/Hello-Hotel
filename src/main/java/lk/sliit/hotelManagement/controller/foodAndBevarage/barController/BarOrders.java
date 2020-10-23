package lk.sliit.hotelManagement.controller.foodAndBevarage.barController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.service.custom.BarBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarOrders {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    BarBO barBO;

    @GetMapping("/barOrder")
    public String loginPage(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryDTO> p1 = barBO.findAllBeverageItems("Beverage");
        if (p1.isEmpty()) {
            request.setAttribute("loginError", "Not Any Item Fond Under Beverage " +
                    "Type Please Add Data Under Beverage Type");
        }
        model.addAttribute("loadInventoryBarTable", p1);
        return "barOrder";
    }

    @RequestMapping("/barSettings")
    public String barSettings1(Model model, HttpServletRequest request) {
        List<InventoryDTO> p1 = inventoryBO.findAllBeverageItems();
        model.addAttribute("loadInventoryBeverage", p1);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute("mode", "MODE_SETTINGS1");
        return "barSettings";
    }

    @PostMapping("invoiceBar")
    public String loadInvoicePage(@ModelAttribute BarOrderDTO barOrderDTO, Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            barOrderDTO.setUser(SuperController.idNo);
            BarOrderDTO top = barBO.findTopByOrderByBarIdDesc();
            int x = (top.getId()) + 1;
            barOrderDTO.setId(x);
        } catch (NullPointerException e) {
            barOrderDTO.setId(1);
        }
        try {
            barBO.saveBarOrder(barOrderDTO);
        } catch (Exception e) {
            return "redirect:/barOrder";
        }
        return "invoice";
    }
}