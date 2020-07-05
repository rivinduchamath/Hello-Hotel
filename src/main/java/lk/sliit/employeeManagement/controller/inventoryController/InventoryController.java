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

    @GetMapping("/inventoryToday")
    public String inventoryToday(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> p = inventoryBO.findTodayInventoryNotice();
        model.addAttribute("findTodayNotice", p);
        return "inventoryToday";
    }


    @RequestMapping(value = "/updateQtyTom")
    public String updateQtyTomorrow(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventoryTomorrow";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventoryTomorrow";
    }

    @RequestMapping(value = "/updateQtyToday")
    public String updateQtyToday(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventoryToday";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventoryToday";
    }

    @RequestMapping(value = "/updateQty")
    public String updateQty(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventory";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventory";
    }

    int dayTwo(List<InventoryNoticeDTO> today, List<InventoryNoticeDTO> tomorrow) {
        int i = 0;
        for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
            for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                if (tomorrowInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())) {
                    return ++i;
                }
            }
        }
        return i;
    }//End day Two Method

    @GetMapping("/inventoryTomorrow")
    public String inventoryTomorrow(Model model) {
        double requiredQty = 0.0;
        double requiredQty2 = 0.0;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //Find Today Notice Data
        List<InventoryNoticeDTO> today = inventoryBO.findTodayInventoryNotice();
        //Find Tomorrow Notice Data
        List<InventoryNoticeDTO> tomorrow = inventoryBO.findTomorrowInventoryNotice();

        int i = dayTwo(today, tomorrow), x = 0;
        System.out.println("Printtttttttttttttttttttttttttttttttttttttttttttttttttt " + i);
        if (i > 0) {
            for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                    x = 0;
                    if ((tomorrowInventoryNoticeDTO.getInventoryId()).equals(todayInventoryNoticeDTO.getInventory()) ) {

                        if (requiredQty > tomorrowInventoryNoticeDTO.getQtyOnHand()) {  x = 0;
                            requiredQty = requiredQty - tomorrowInventoryNoticeDTO.getQtyOnHand();
                            tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);
                            System.out.println(requiredQty + "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

                        } else {
                            requiredQty = (tomorrowInventoryNoticeDTO.getOrderQty() + todayInventoryNoticeDTO.getOrderQty()) - tomorrowInventoryNoticeDTO.getQtyOnHand();
                            tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);
                            System.out.println(tomorrowInventoryNoticeDTO.getOrderQty() + "pppppppppppppppppppppppppppppppppppppppppppppppp");
                            System.out.println(todayInventoryNoticeDTO.getOrderQty() + "pppppppppppppppppppppppppppppppppppppppppppppppp");
                            System.out.println(requiredQty + "pppppppppppppppppppppppppppppppppppppppppppppppp");
                        }
                    }
                }
            }
        } else {
            for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {

                requiredQty = tomorrowInventoryNoticeDTO.getOrderQty() - tomorrowInventoryNoticeDTO.getQtyOnHand();
                tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);
            }
        }
        model.addAttribute("findTodayNotice", tomorrow);
        return "inventoryTomorrow";
    }


    @GetMapping("/inventory")
    public String inventoryDayAfterTomorrow(Model model) {
        double requiredQty = 0.0;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryNoticeDTO> today = inventoryBO.findTodayInventoryNotice();
        List<InventoryNoticeDTO> tomorrow = inventoryBO.findTomorrowInventoryNotice();
        List<InventoryNoticeDTO> dayAfter = inventoryBO.findDayAfterTomorrowNotice();

        int i = dayDTwo(today, tomorrow, dayAfter), x = 0;

        if (i > 0) {
            for (InventoryNoticeDTO dayAfterInventoryNoticeDTO : dayAfter) {
                for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                    for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory()) && x == 0) {
                            requiredQty = 0.0;
                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);


                            } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() + todayInventoryNoticeDTO.getOrderQty()) - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            }
                        }
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(tomorrowInventoryNoticeDTO.getInventory()) && x == 0) {
                            requiredQty = 0.0;
                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() + tomorrowInventoryNoticeDTO.getOrderQty()) - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            }
                        }
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(tomorrowInventoryNoticeDTO.getInventory()) &&
                                dayAfterInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())) {
                            x = 0;
                            requiredQty = 0.0;
                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
                                x = 1;
                                  } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() + todayInventoryNoticeDTO.getOrderQty() +
                                        tomorrowInventoryNoticeDTO.getOrderQty()) - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
                                x = 1;
                            }
                        }
                    }
                }
            }
        } else {
            for (InventoryNoticeDTO dayAfterInventoryNoticeDTO : dayAfter) {
                requiredQty = dayAfterInventoryNoticeDTO.getOrderQty() - dayAfterInventoryNoticeDTO.getQtyOnHand();
                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
            }
        }

        model.addAttribute("findDayAfterTomorrowNotice", dayAfter);
        return "inventory";
    }

    private int dayDTwo(List<InventoryNoticeDTO> today, List<InventoryNoticeDTO> tomorrow, List<InventoryNoticeDTO> dayAfter) {
        int i = 0;
        for (InventoryNoticeDTO dayAfterInventoryNoticeDTO : dayAfter) {
            for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {

                    if (dayAfterInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())) {
                        ++i;
                    }
                    if (dayAfterInventoryNoticeDTO.getInventoryId().equals(tomorrowInventoryNoticeDTO.getInventory())) {
                        ++i;
                    }
                }
            }
        }
        return i;
    }
}
