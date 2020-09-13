package lk.sliit.hotelManagement.controller.inventoryController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.service.custom.BarBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarStockController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    BarBO barBO;
    @Autowired
    InventoryBO inventoryBO;

    @GetMapping("/barStock")
    public String loginPage(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryDTO> p1 = barBO.findAllBeverageItems("Beverage");
        if(p1.isEmpty()){
            request.setAttribute("loginError","Not Any Item Fond Under Beverage " +
                    "Type Please Add Data Under Beverage Type" );
        }
        model.addAttribute("loadInventoryBar", p1);
        return "barStock";
    }

    @PostMapping("addBarNotice")
    public String addBarNotice(@ModelAttribute InventoryNoticeDTO noticeDTO, Model model, HttpServletRequest request) {
        model.addAttribute ( "loggerName", indexLoginBO.getEmployeeByIdNo ( SuperController.idNo ) );

        try {noticeDTO.setOrderHolder(SuperController.idNo);
            InventoryNoticeDTO top = inventoryBO.findTopByBarNoticeIdDesc ( );
            int x = ( top.getNoticeId ( ) )+ 1;
            noticeDTO.setNoticeId ( ( x ) );
        } catch (NullPointerException e) {
            noticeDTO.setNoticeId (  ( 1 ) );
        }

        inventoryBO.saveOrderNotice(noticeDTO);


        return "invoice";
    }
}
