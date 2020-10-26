package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.*;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.service.SuperBO;


import java.sql.Date;
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

    List<MenuDTO> findMenusByType(String type);

    MenuDTO findMaxMenuIdByType(String type);

    MenuDTO findMinMenuIdByType(String type);



    List<RestaurantCounterOrderDetailDTO> findAllOrders();



    void deleteItemFromPack(int menuItemId, int foodItemID);



    void saveKitchenFoodOrder(KitchenFoodOrderDTO kitchenFoodOrderDTO);

    void deleteKitchenFoodOrder(int id);

    KitchenFoodOrderDTO loadKitchenFoodOrderById( int id);

    List<KitchenFoodOrderDTO> loadKitchenFoodOrderBydateAndDescription(Date date, String description);

    List<KitchenFoodOrderDTO> loadKitchenFoodOrderByDescription(String description);



    void saveDailyMenuId(String id);

    public List<MenuDTO> getDailyMenuByType();

    void saveMenuDate(LimitDTO limitDTO);

    LimitDTO findMenuDate();



    void saveInventoryNotice(KitchenInventoryNoticeDTO inventoryNoticeDTO);

    KitchenInventoryNoticeDTO findInventoryNotice(Date date, int foodItemId);

    int findMaxKitchenOrderId();

    List<InventoryDTO> findKitchenInventory(String s);

    KitchenFoodOrderDTO getExistingKitchenFoodOrder(int foodItemId, Date expectedDate, String description);
}
