package lk.sliit.hotelManagement.controller.foodAndBevarage.Restaurant;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OnlineOrder {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    OnlineCustomerBO onlineCustomerBO;
    @Autowired
    RestaurantBO restaurantBO;

    @GetMapping("/onlineOrder")
    public String loadForm_validationSaveMode(Model model, HttpSession session, HttpServletRequest request) {
        System.out.println("222333333333333222222222222222222");
        try {
            String onlineCustomerId = session.getAttribute("userId").toString();
            model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
//            Load All Food
            List<FoodItemDTO> p1 = restaurantBO.findAllFoodItems("Restaurant");
            if(p1.isEmpty()){
                request.setAttribute("loginError","Not Any Item Fond Under Restaurant " +
                        "Type Please Add Data Under Restaurant Type" );
            }
            for (FoodItemDTO d: p1) {
                System.out.println(d+"2222222222222222222222222222222222222222222222222222222222222222222");
            }
            model.addAttribute("loadAllFoods", p1);
        } catch (NullPointerException d) {
            return "onlineOrder";
        }
        return "onlineOrder";

    }
}