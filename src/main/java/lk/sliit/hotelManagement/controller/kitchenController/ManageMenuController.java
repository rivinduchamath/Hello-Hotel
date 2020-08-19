package lk.sliit.hotelManagement.controller.kitchenController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ManageMenuController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @PostMapping("/FoodPacks")
    public String addFoodPack(Model model, @ModelAttribute MenuDTO menuDTO){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        try {
            MenuDTO menuItem = kitchenBO.findHighestFoodPackId();
            int maxId = Integer.parseInt(menuItem.getMenuId());
            if (menuDTO.getMenuId().equals(String.valueOf(maxId))){
                menuDTO.setMenuId(String.valueOf(maxId));
            } else {
                maxId++;
                menuDTO.setMenuId(String.valueOf(maxId));
            }

        } catch (NullPointerException e){
            menuDTO.setMenuId("1");
        }
        kitchenBO.saveMenuItem(menuDTO);
        return "redirect:/manageFoodPacks";
    }

    @GetMapping("/manageFoodPacks")
    public String foodPackPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<MenuDTO> menuItemList = kitchenBO.findMenuItems();
        List<FoodItemDTO> foodItemDTOList = kitchenBO.findFoodItems();
        model.addAttribute("loadFoodItemTable", foodItemDTOList);
        model.addAttribute("loadMenuItemTable", menuItemList);
        return "manageFoodPacks";
    }



    @GetMapping(value = "/deleteFoodPackage/{menuId}")
    public void deleteMenuItem(Model model, @PathVariable("menuId") String menuItemId, HttpServletResponse response){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        kitchenBO.deleteMenuItem(menuItemId);
        try {
            response.sendRedirect("/manageFoodPacks");
        } catch (IOException e){

        }
    }


    @RequestMapping("/foodPackManagement")
    public String addItemToMenu(Model model, @RequestParam String menuId){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("menuItem", kitchenBO.findMenuItemById(menuId));
        model.addAttribute("loadFoodItemTable",kitchenBO.findFoodItems());
        return "foodPackManagement";

    }
}
