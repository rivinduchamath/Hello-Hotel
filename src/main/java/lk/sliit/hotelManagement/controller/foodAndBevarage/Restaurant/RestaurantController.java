package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
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
        if(p1.isEmpty()){
            request.setAttribute("loginError","Not Any Item Fond Under Restaurant " +
                    "Type Please Add Data Under Restaurant Type" );
        }
        for (FoodItemDTO d: p1) {
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
    @PostMapping("invoiceRestaurantOrder")
    public String loadInvoicePage(@ModelAttribute RestaurantCounterOrderDTO restaurantCounterOrderDTO, Model model, HttpServletRequest request) {
        model.addAttribute ( "loggerName", indexLoginBO.getEmployeeByIdNo ( SuperController.idNo ) );


        try {restaurantCounterOrderDTO.setCustomerId(SuperController.idNo);
            RestaurantCounterOrderDTO top = restaurantBO.findTopByOrderByRestIdDesc ( );
            int x = Integer.parseInt ( top.getOrderId ( ) )+ 1;
            restaurantCounterOrderDTO.setOrderId ( String.valueOf ( x ) );
        } catch (NullPointerException e) {
            restaurantCounterOrderDTO.setOrderId ( String.valueOf ( 1 ) );
        }

        restaurantBO.saveRestaurantOrder(restaurantCounterOrderDTO);


        return "invoice";
    }
}
