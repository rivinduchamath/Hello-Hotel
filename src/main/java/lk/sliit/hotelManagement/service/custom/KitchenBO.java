package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDetailsDAO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.service.SuperBO;



import java.util.List;

public interface KitchenBO extends SuperBO {
    void saveFoodItem(FoodItemDTO foodItemDTO);

    List<FoodItemDTO> findFoodItems();

    FoodItemDTO findHighestId();

    void deleteFoodItem(int foodItemId);

    MenuDTO findHighestFoodPackId();

    void saveMenuItem(MenuDTO menuDTO);

    List<MenuDTO> findMenuItems();

    void deleteMenuItem(int menuItemId);

    MenuDTO findMenuItemById(int menuItemId);

    void saveFoodDetail(MenuDetailsDTO menuDTO);

    List<MenuDetailsDTO> findFoodItemsDetails(int menuId);


    List<InventoryNoticeDTO> findWeekOrderNotice();

    FoodItemDTO findFoodItemById(int itemId);

    List<RestaurantCounterOrderDetailDTO> findAllOrders();

    void deleteItemFromPack(int menuItemId, int foodItemID);
}
