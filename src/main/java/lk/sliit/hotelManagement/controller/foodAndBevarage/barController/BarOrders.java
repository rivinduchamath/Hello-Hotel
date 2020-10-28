package lk.sliit.hotelManagement.controller.foodAndBevarage.barController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDetailDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.service.custom.BarBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @PostMapping("barBill")
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

            java.util.List<BarOrderDetailDTO> list = new ArrayList<BarOrderDetailDTO>();
            String arr = barOrderDTO.getOrderData();
            String yo[] = arr.split(" ");
            int count = 0;
            BarOrderDetailDTO itm = new BarOrderDetailDTO();
            for(String str:yo) {
                if(count == 0 ) {
                    itm = new BarOrderDetailDTO();
                    itm.setItemCode(Integer.parseInt(str));
                    count ++;

                }else if(count == 1) {
                    itm.setItemPrice(Double.parseDouble(str));
                    count ++;

                }else if(count == 2) {
                    itm.setQty(Double.parseDouble(str));
                    list.add(itm);
                    count = 0;
                }
            }


            for (BarOrderDetailDTO d : list) {
                InventoryDTO f = barBO.findById(d.getItemCode());
                d.setItemName(f.getText());
            }
            model.addAttribute("listBarOrders", barOrderDTO.getId());
            model.addAttribute("listBarOrderDetails", list);//Load Data to Payment

        } catch (Exception e) {
            return "redirect:/barOrder";
        }
        return "barBill";
    }
}