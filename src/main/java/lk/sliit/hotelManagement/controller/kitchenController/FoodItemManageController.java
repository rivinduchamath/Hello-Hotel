package lk.sliit.hotelManagement.controller.kitchenController;


import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.inventory.SupplierDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class FoodItemManageController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/manageMenu")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<FoodItemDTO> foodItemList = kitchenBO.findFoodItems();
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        model.addAttribute("foodItemDTO", foodItemDTO);
        model.addAttribute("loadFoodItemTable", foodItemList);
        return "manageMenu";
    }

    @PostMapping("/saveFoodItem")
    public String addNew(Model model, @ModelAttribute FoodItemDTO foodItemDTO) {

        try {
            FoodItemDTO foodItemDTO2 = kitchenBO.findHighestId();
            FoodItemDTO foodItemDTO1 = null;
            try {
                foodItemDTO1 = kitchenBO.findFoodItemById(foodItemDTO.getItemId());
            }catch (NullPointerException d){
                int maxId = (foodItemDTO2.getItemId());
                if (foodItemDTO.getItemId()==(maxId)) {
                    foodItemDTO.setItemId((maxId));
                } else {
                    maxId++;
                    foodItemDTO.setItemId((maxId));
                }
            }
        } catch (NullPointerException e){
            foodItemDTO.setItemId(1);
        }

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        kitchenBO.saveFoodItem(foodItemDTO);
        return "redirect:/manageMenu";
    }

    @GetMapping(value = "deleteFoodItem/{itemId}")
    public String deleteFoodItem(@PathVariable("itemId") int foodItemId, HttpServletResponse response) {
        List<RestaurantCounterOrderDetailDTO> p = kitchenBO.findAllOrders();
        for (RestaurantCounterOrderDetailDTO s : p) {
            if (s.getFoodItem() == foodItemId) {
                return "redirect:/manageMenu";
            }
        }
        kitchenBO.deleteFoodItem(foodItemId);
        return "redirect:/manageMenu";
    }
}


