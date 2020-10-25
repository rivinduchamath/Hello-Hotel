package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.service.custom.BarBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    RestaurantBO restaurantBO;
    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/restaurant")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurant";
    }


    @GetMapping("/restaurantOrder")
    public String restaurantOrders(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        //List<FoodItemDTO> p1 = restaurantBO.findAllFoodItems("Restaurant");
        List<FoodItemDTO> p1 = kitchenBO.findFoodItems();

        if (p1.isEmpty()) {
            request.setAttribute("loginError", "Not Any Fond Items" +
                    " Please Add Food Items ");
        }
        for (FoodItemDTO d : p1) {
            System.out.println(d);
        }
        model.addAttribute("loadInventoryRestaurantTable", p1);
        return "restaurantOrder";
    }

    @GetMapping("/restaurantBill")
    public String restaurantBill(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurantBill";
    }


    @PostMapping("invoice")
    public String loadInvoicePage(@ModelAttribute RestaurantCounterOrderDTO restaurantCounterOrderDTO, Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            restaurantCounterOrderDTO.setCustomerId(SuperController.idNo);
            RestaurantCounterOrderDTO top = restaurantBO.findTopByOrderByRestIdDesc();
            int x = (top.getOrderId()) + 1;
            restaurantCounterOrderDTO.setOrderId((x));
        } catch (NullPointerException e) {
            restaurantCounterOrderDTO.setOrderId((1));
        }
        try {
            restaurantBO.saveRestaurantOrder(restaurantCounterOrderDTO);
//////////////////////////////////////////////////////////////////////////////////
            java.util.List<RestaurantCounterOrderDetailDTO> list = new ArrayList<>();
            String arr = restaurantCounterOrderDTO.getDataValue();
            String yo[] = arr.split(" ");
            int count = 0;
            RestaurantCounterOrderDetailDTO itm = new RestaurantCounterOrderDetailDTO();
            for (String str : yo) {
                if (count == 0) {
                    itm = new RestaurantCounterOrderDetailDTO();
                    itm.setFoodItem(Integer.parseInt(str));
                    count++;

                } else if (count == 1) {
                    itm.setUnitePrice(Double.parseDouble(str));
                    count++;

                } else if (count == 2) {
                    itm.setQuantity(Double.parseDouble(str));
                    list.add(itm);
                    count = 0;
                }
            }

//            ////////////////////////////////////////////////////////////////
            for (RestaurantCounterOrderDetailDTO d : list) {
                FoodItemDTO f = kitchenBO.findFoodItemById(d.getFoodItem());
                d.setName(f.getItemName());
            }

            model.addAttribute("listCounterOrders", restaurantCounterOrderDTO.getOrderId());
            model.addAttribute("listCounterOrderDetails", list);

        } catch (Exception e) {
            return "redirect:/restaurantOrder";
        }
        return "invoice";
    }

    @GetMapping("/invoice")
    public String restaurant(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "invoice";
    }

    @GetMapping("/restaurantManage")
    public String restaurantManage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<RestaurantOnlineOrderDTO> tableList = restaurantBO.findOrderOnline();
        model.addAttribute("listAllOnlineOrders", tableList);
        List<OnlineTableReservationDTO> tableList1 = restaurantBO.findTablesOnline();
        model.addAttribute("onlineTableReservation", tableList1);

        return "restaurantManage";
    }


}
