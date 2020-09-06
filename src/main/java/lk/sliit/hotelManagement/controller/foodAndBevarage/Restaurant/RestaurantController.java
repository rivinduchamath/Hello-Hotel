package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.service.custom.BarBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RestaurantController {
    @Autowired
    BarBO barBO;
    @Autowired
    IndexLoginBO indexLoginBO;

    @GetMapping("/restaurant")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurant";
    }
    @GetMapping("/restaurantOrder")
    public String restaurantOrders(Model model, HttpServletRequest request) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<InventoryDTO> p1 = barBO.findAllBeverageItems("Restaurant");
        if(p1.isEmpty()){
            request.setAttribute("loginError","Not Any Item Fond Under Restaurant " +
                    "Type Please Add Data Under Restaurant Type" );
        }
        for (InventoryDTO d: p1) {
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
}
