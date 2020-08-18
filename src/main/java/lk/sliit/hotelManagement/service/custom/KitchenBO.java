package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.service.SuperBO;



import java.util.List;

public interface KitchenBO extends SuperBO {
    void saveFoodItem(FoodItemDTO foodItemDTO);

    List<FoodItemDTO> findFoodItems();

    FoodItemDTO findHighestId();

    void deleteFoodItem(String foodItemId);

    MenuDTO findHighestFoodPackId();

    void saveMenuItem(MenuDTO menuDTO);

    List<MenuDTO> findMenuItems();

    void deleteMenuItem(String menuItemId);

    MenuDTO findMenuItemById(String menuItemId);
}
