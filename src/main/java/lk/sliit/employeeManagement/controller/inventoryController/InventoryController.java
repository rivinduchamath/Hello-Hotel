package lk.sliit.employeeManagement.controller.inventoryController;

import lk.sliit.employeeManagement.controller.SuperController;
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

    //Automate Object Creation
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    InventoryBO inventoryBO;

    //Load Today Inventory Page
    @GetMapping("/inventoryToday")
    public String inventoryToday(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        //Load Data To Today Inventory Notice
        List<InventoryNoticeDTO> p = inventoryBO.findTodayInventoryNotice();
        model.addAttribute("findTodayNotice", p);
        return "inventoryToday";
    } //End Load Today Inventory Page


    //Update Tomorrow Quantity in Table Input Field Change Quantity On Hand
    @RequestMapping(value = "/updateQtyTom")
    public String updateQtyTomorrow(@ModelAttribute InventoryDTO inventoryDTO) {
        //Create InventoryDTO Reference
        InventoryDTO inventoryDTO1;
        try {
            //Get Inventory Data From Inventory Id
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            //Add New Qty To Current Qty On Hand
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            //Update InventoryDTO1
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventoryTomorrow";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventoryTomorrow";
    }//End Update Qty On Hand On Tomorrow

    //Update Today Quantity in Table Input Field Change Quantity On Hand
    @RequestMapping(value = "/updateQtyToday")
    public String updateQtyToday(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            //Get Inventory Data From Inventory Id
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            //Add New Qty To Current Qty On Hand
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            //Update InventoryDTO1
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventoryToday";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventoryToday";
    }//End Update Qty On Hand On Today

    //Update DayAfterTomorrow Quantity in Table Input Field Change Quantity On Hand
    @RequestMapping(value = "/updateQty")
    public String updateQty(@ModelAttribute InventoryDTO inventoryDTO) {

        InventoryDTO inventoryDTO1;
        try {
            //Get Inventory Data From Inventory Id
            inventoryDTO1 = inventoryBO.findInventory(inventoryDTO.getInventoryId());
            //Add New Qty To Current Qty On Hand
            inventoryDTO1.setOrderQty(inventoryDTO.getOrderQty() + inventoryDTO1.getOrderQty());
            //Update InventoryDTO1
            inventoryBO.updateInventory(inventoryDTO1);
            return "redirect:/inventory";
        } catch (Exception w) {
            System.out.println("Error");
        }
        return "redirect:/inventory";
    }//End Update Qty On Hand On DayAfterTomorrow



    //Calculate inventory tomorrow required quantity for each Item
    @GetMapping("/inventoryTomorrow")
    public String inventoryTomorrow(Model model) {
        double requiredQty = 0.0;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //Find Today Notice Data
        List<InventoryNoticeDTO> today = inventoryBO.findTodayInventoryNotice();
        //Find Tomorrow Notice Data
        List<InventoryNoticeDTO> tomorrow = inventoryBO.findTomorrowInventoryNotice();

        //Call Method dayTwo to find Duplicate inventory id's
        int i = dayTwo(today, tomorrow), x = 0;

        //If Found duplicate id's
        if (i > 0) {
            for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                    x = 0;
                    //if NO1
                    if ((tomorrowInventoryNoticeDTO.getInventoryId()).equals(todayInventoryNoticeDTO.getInventory())) {

                        if (requiredQty > tomorrowInventoryNoticeDTO.getQtyOnHand()) {
                            x = 0;
                            requiredQty = requiredQty - tomorrowInventoryNoticeDTO.getQtyOnHand();
                            tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);

                        } else {
                            requiredQty = (tomorrowInventoryNoticeDTO.getOrderQty() +
                                    todayInventoryNoticeDTO.getOrderQty()) -
                                    tomorrowInventoryNoticeDTO.getQtyOnHand();
                            tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);
                        }
                    }//End if NO1
                }//end 2nd for
            }//end 1st for
        } else {
            //If not found duplicate id's
            for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                requiredQty = tomorrowInventoryNoticeDTO.getOrderQty() -
                        tomorrowInventoryNoticeDTO.getQtyOnHand();
                tomorrowInventoryNoticeDTO.setRequiredQty(requiredQty);
            }
        }
        model.addAttribute("findTodayNotice", tomorrow);//Add Data To the Table
        return "inventoryTomorrow";
    }//END Calculate inventory tomorrow required quantity for each Item

    //dayTwo Method Call From inventoryTomorrow Method to Find weather Inventory Id Already In previous Day
    int dayTwo(List<InventoryNoticeDTO> today, List<InventoryNoticeDTO> tomorrow) {
        int i = 0;
        for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
            for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                if (tomorrowInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())) {
                    return ++i;//If Already in return i > 0 else Return 0
                }
            }
        }//end 1st for
        return i;
    }//End day Two Method

    // Calculate inventory DayAfterTomorrow required quantity for each Item
    @GetMapping("/inventory")
    public String inventoryDayAfterTomorrow(Model model) {
        double requiredQty = 0.0;
        //load logged User Data
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        //Find Today Notice Data
        List<InventoryNoticeDTO> today = inventoryBO.findTodayInventoryNotice();
        //Find Tomorrow Notice Data
        List<InventoryNoticeDTO> tomorrow = inventoryBO.findTomorrowInventoryNotice();
        //Find DayAfterTomorrow Notice Data
        List<InventoryNoticeDTO> dayAfter = inventoryBO.findDayAfterTomorrowNotice();

        //Call Method dayDTwo to find Duplicate inventory id's
        int i = dayDTwo(today, tomorrow, dayAfter), x = 0;

        //If Found duplicate id's
        if (i > 0) {
            for (InventoryNoticeDTO dayAfterInventoryNoticeDTO : dayAfter) {
                for (InventoryNoticeDTO tomorrowInventoryNoticeDTO : tomorrow) {
                    for (InventoryNoticeDTO todayInventoryNoticeDTO : today) {
                        //if NO1
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory()) && x == 0) {
                            requiredQty = 0.0;
                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);


                            } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() + todayInventoryNoticeDTO.getOrderQty()) - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            }
                        }  //End if NO1

                        //if NO2
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(tomorrowInventoryNoticeDTO.getInventory()) && x == 0) {
                            requiredQty = 0.0;

                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() + tomorrowInventoryNoticeDTO.getOrderQty()) - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);

                            }
                        }  //End if NO2

                        //if NO3
                        if (dayAfterInventoryNoticeDTO.getInventoryId().equals(tomorrowInventoryNoticeDTO.getInventory()) &&
                                dayAfterInventoryNoticeDTO.getInventoryId().equals(todayInventoryNoticeDTO.getInventory())) {
                            x = 0;
                            requiredQty = 0.0;
                            if (requiredQty > dayAfterInventoryNoticeDTO.getQtyOnHand()) {
                                requiredQty = requiredQty - dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
                                x = 1;
                            } else {
                                requiredQty = (dayAfterInventoryNoticeDTO.getOrderQty() +
                                        todayInventoryNoticeDTO.getOrderQty() +
                                        tomorrowInventoryNoticeDTO.getOrderQty()) -
                                        dayAfterInventoryNoticeDTO.getQtyOnHand();
                                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
                                x = 1;
                            }
                        }  //End if NO3
                    }//3rd for
                }//2nd for
            }//3rd for
        } else { //If NOT Found duplicate id's
            for (InventoryNoticeDTO dayAfterInventoryNoticeDTO : dayAfter) {
                requiredQty = dayAfterInventoryNoticeDTO.getOrderQty() -
                        dayAfterInventoryNoticeDTO.getQtyOnHand();
                dayAfterInventoryNoticeDTO.setRequiredQty(requiredQty);
            }
        }//End else

        //Load DayAfter Table Data
        model.addAttribute("findDayAfterTomorrowNotice", dayAfter);
        return "inventory";
    }//End Calculate inventory DayAfterTomorrow required quantity for each Item

    //dayDTwo Method Call From inventoryTomorrow Method to Find weather Inventory Id Already In previous Days'
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
                }//end for 3
            }//end for2
        }//end for 1
        return i;//If found duplicate return i > 0
    }//End dayDTwo Method

}//End Class Inventory Controller
