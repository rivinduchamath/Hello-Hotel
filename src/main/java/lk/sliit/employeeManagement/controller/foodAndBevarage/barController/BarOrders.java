package lk.sliit.employeeManagement.controller.foodAndBevarage.barController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.BarOrderDTO;
import lk.sliit.employeeManagement.dto.BarOrderDetailDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.service.custom.BarBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarOrders {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BarBO barBO;

    @GetMapping("/barOrder")
    public String loginPage(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryDTO> p1 = barBO.findAllBeverageItems("Beverage");
        if(p1.isEmpty()){
            request.setAttribute("loginError","Not Any Item Fond Under Beverage " +
                    "Type Please Add Data Under Beverage Type" );
        }
        model.addAttribute("loadInventoryBarTable", p1);
        return "barOrder";
    }

    @RequestMapping("/barSettings")
    public String barSettings1(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        request.setAttribute ( "mode", "MODE_SETTINGS1" );
        return "barSettings";
    }

    @PostMapping("invoiceBar")
    public String loadInvoicePage(@ModelAttribute BarOrderDTO barOrderDTO, Model model, HttpServletRequest request) {
        model.addAttribute ( "loggerName", indexLoginBO.getEmployeeByIdNo ( SuperController.idNo ) );
        try {
            barOrderDTO.setUser(SuperController.idNo);
            List<BarOrderDTO> totalCount = barBO.findAllBarOrders ( );
            int  i= 0;
            for (BarOrderDTO dto: totalCount) {
                i++;
            }
              barOrderDTO.setId ( String.valueOf ( i ) );
        } catch (NullPointerException e) {
            barOrderDTO.setId ( String.valueOf ( 1 ) );
        }

         barBO.saveBarOrder(barOrderDTO);



          return "invoice";
    }
}
