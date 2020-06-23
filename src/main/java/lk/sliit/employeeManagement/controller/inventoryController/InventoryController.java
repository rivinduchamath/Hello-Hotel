package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.service.custom.DashboardBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InventoryController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    DashboardBO dashboardBO;

    @GetMapping("/inventory")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<NoticeDTO> p =  indexLoginBO.findResentNoticeDesc();
        model.addAttribute ( "findAllNotice", p );
        return "inventory";
    }
}
