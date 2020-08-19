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
        model.addAttribute("loadMenuItemTable", menuItemList);
        return "manageFoodPacks";
    }

    @PostMapping("/foodPack")
    public String manageFoodPack(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<FoodItemDTO> foodItemDTOList = kitchenBO.findFoodItems();
        model.addAttribute("loadFoodItemTable", foodItemDTOList);
        return "foodPackManagement";
    }

    @PostMapping("/addToMenu")
    public String addFoodToMenu(Model model){

        return "foodPackManagement";
    }

    @GetMapping(value = "/deleteFoodPackage/{menuId}")
    public void deleteMenuItem(@PathVariable("menuId") String menuItemId, HttpServletResponse response){
        kitchenBO.deleteMenuItem(menuItemId);
        try {
            response.sendRedirect("/manageFoodPacks");
        } catch (IOException e){

        }
    }

    @GetMapping(value = "/foodPackage/{menuId}")
    public String addItemToMenu(Model model, @PathVariable("menuId") String menuItemId){
        MenuDTO menuDTO = kitchenBO.findMenuItemById(menuItemId);
        model.addAttribute("menuItem", menuDTO);
        List<FoodItemDTO> foodItemDTOList = kitchenBO.findFoodItems();
        model.addAttribute("loadFoodItemTable",foodItemDTOList);
        return "foodPackManagement";
    }
}