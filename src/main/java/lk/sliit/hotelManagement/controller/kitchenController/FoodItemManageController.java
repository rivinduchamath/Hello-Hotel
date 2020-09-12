package lk.sliit.hotelManagement.controller.kitchenController;


import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
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
        model.addAttribute("loadFoodItemTable", foodItemList);
        return "manageMenu";
    }

    @PostMapping("/saveFoodItem")
    public String addNew(Model model, @ModelAttribute FoodItemDTO foodItemDTO) {
        System.out.println(foodItemDTO+" aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        try {
            foodItemDTO.setItemId(Integer.parseInt(foodItemDTO.getGetId()));
        }catch (NumberFormatException e){

        }
        try {

            FoodItemDTO lastItem = kitchenBO.findHighestId();
            System.out.println(lastItem+" sssssssssssssssssssssssssssssssssssssssssss");
            int maxId = (lastItem.getItemId());

            if (foodItemDTO.getItemId()==((maxId))){
                foodItemDTO.setItemId((maxId));
            } else {
                maxId++;
                foodItemDTO.setItemId((maxId));
            }

        } catch (NullPointerException e) {
            foodItemDTO.setItemId(1);
        }

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        kitchenBO.saveFoodItem(foodItemDTO);
        return "redirect:/manageMenu";
    }

    @GetMapping(value = "deleteFoodItem/{itemId}")
    public void deleteFoodItem(@PathVariable("itemId") int foodItemId, HttpServletResponse response) {
        kitchenBO.deleteFoodItem(foodItemId);
        try {
            response.sendRedirect("/manageMenu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


