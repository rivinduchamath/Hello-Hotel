package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
import lk.sliit.employeeManagement.dto.NoticeDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.employeeManagement.service.custom.DashboardBO;
import lk.sliit.employeeManagement.service.custom.IndexLoginBO;
import lk.sliit.employeeManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InventoryController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    InventoryBO inventoryBO;

    @GetMapping("/inventory")
    public String inventoryDayAfterTomorrow(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> p = inventoryBO.findDayAfterTomorrowNotice();
        model.addAttribute("findDayAfterTomorrowNotice", p);
        return "inventory";
    }

    @GetMapping("/inventoryToday")
    public String inventoryToday(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> p = inventoryBO.findTodayInventoryNotice();
        model.addAttribute("findTodayNotice", p);
        return "inventoryToday";
    }

    @GetMapping("/inventoryTomorrow")
    public String inventoryTomorrow(Model model) {
        double requiredQty = 0.0;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> today = inventoryBO.findTodayInventoryNotice();

        List<InventoryNoticeDTO> tomorrow = inventoryBO.findTomorrowInventoryNotice();
        for (InventoryNoticeDTO inventoryNoticeDTO :tomorrow){
            for (InventoryNoticeDTO todayInventoryNoticeDTO :today){
               if(inventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())){
                      requiredQty = inventoryNoticeDTO.getOrderQty()+ todayInventoryNoticeDTO.getOrderQty();
                      inventoryNoticeDTO.setRequiredQty(requiredQty);
               }
            }
        }

        model.addAttribute("findTodayNotice", tomorrow);
        return "inventoryTomorrow";
    }

/*
    @RequestMapping(value = "/updateStateDayAfterTomorrow/{noticeId}", method = RequestMethod.GET)
    public String updateStateDayAfterTomorrow(@PathVariable String noticeId) {
        InventoryNoticeDTO inventoryNoticeDTO;
        try {
            inventoryNoticeDTO = inventoryBO.findInventoryNotice(noticeId);
            if (inventoryNoticeDTO != null) {
                if (inventoryNoticeDTO.isState()) {
                    inventoryNoticeDTO.setState(false);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventory";
                } else {
                    inventoryNoticeDTO.setState(true);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventory";
                }
            } else {
                return "redirect:/inventory";
            }
        } catch (NullPointerException e) {
            System.out.println("Order Is Deleted");
        }

        return "redirect:/inventory";
    }

    @RequestMapping(value = "/updateStateToday/{noticeId}", method = RequestMethod.GET)
    public String updateStateToday(@PathVariable String noticeId) {
        InventoryNoticeDTO inventoryNoticeDTO;
        try {
            inventoryNoticeDTO = inventoryBO.findInventoryNotice(noticeId);
            if (inventoryNoticeDTO != null) {
                if (inventoryNoticeDTO.isState()) {
                    inventoryNoticeDTO.setState(false);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventoryToday";
                } else {
                    inventoryNoticeDTO.setState(true);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventoryToday";
                }
            } else {
                return "redirect:/inventoryToday";
            }
        } catch (NullPointerException e) {
            System.out.println("Order Is Deleted");
        }

        return "redirect:/inventoryToday";
    }
    @RequestMapping(value = "/updateStateTomorrow/{noticeId}", method = RequestMethod.GET)
    public String updateStateTomorrow(@PathVariable String noticeId) {
        InventoryNoticeDTO inventoryNoticeDTO;
        try {
            inventoryNoticeDTO = inventoryBO.findInventoryNotice(noticeId);
            if (inventoryNoticeDTO != null) {
                if (inventoryNoticeDTO.isState()) {
                    inventoryNoticeDTO.setState(false);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventoryTomorrow";
                } else {
                    inventoryNoticeDTO.setState(true);
                    inventoryBO.updateNoticeState(inventoryNoticeDTO);
                    return "redirect:/inventoryTomorrow";
                }
            } else {
                return "redirect:/inventoryTomorrow";
            }
        } catch (NullPointerException e) {
            System.out.println("Order Is Deleted");
        }

        return "redirect:/inventoryTomorrow";
    }

*/



    @RequestMapping(value = "/updateQty")
    public String updateQty(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
                    inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty()+inventoryDTO1.getOrderQty());
                    inventoryBO.updateInventory(inventoryDTO1);
                    return "redirect:/inventory";
        }catch (Exception w){
            System.out.println("Errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");

        }
           return "redirect:/inventory";
    }
}
