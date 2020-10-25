package lk.sliit.hotelManagement.service.custom;

import com.sun.org.apache.xpath.internal.operations.Or;
import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.KitchenFoodOrderDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.service.SuperBO;


import javax.xml.soap.SAAJResult;
import java.sql.Date;
import java.util.List;

public interface KitchenBO extends SuperBO {
    void saveFoodItem(FoodItemDTO foodItemDTO);

    List<FoodItemDTO> findFoodItems();

    List<FoodItemDTO> findFoodItemsForMenu();

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

    List<KitchenFoodOrderDTO> loadKitchenFoodOrderBydate(Date date);

    List<KitchenFoodOrderDTO> loadKitchenFoodOrderByDescription(String description);

    void saveDailyMenuId(String id);

    public List<MenuDTO> getDailyMenuByType();

    void saveMenuDate(LimitDTO limitDTO);

    LimitDTO findMenuDate();

    void saveInventoryNotice(InventoryNoticeDTO inventoryNoticeDTO);

    int findMaxKitchenOrderId();

    List<InventoryDTO> findKitchenInventory(String s);

}
