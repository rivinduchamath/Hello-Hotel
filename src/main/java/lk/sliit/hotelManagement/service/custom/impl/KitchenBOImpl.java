package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryNoticeDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Transactional
@Service
public class KitchenBOImpl implements KitchenBO {
    @Autowired
    KitchenDAO kitchenDAO;
    @Autowired
    MenuDAO menuDAO;
    @Autowired
    MenuDetailsDAO menuDetailsDAO;
    @Autowired
    InventoryNoticeDAO inventoryNoticeDAO;
    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetail;
    @Autowired
    RestaurantOnlineOrderDetailsDAO onlineOrderDetailsDAO;
    @Override
    public void saveFoodItem(FoodItemDTO foodItemDTO) {
        kitchenDAO.save(new FoodItem
                (foodItemDTO.getItemId(),
                        foodItemDTO.getItemName(),
                        foodItemDTO.getUnitePrice(),
                        foodItemDTO.getSrc(),
                        foodItemDTO.getItemCategory()));
    }

    @Override
    public List<FoodItemDTO> findFoodItems() {
        Iterable<FoodItem> foodItems = kitchenDAO.findAll();
        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();

        for (FoodItem item: foodItems) {
            foodItemDTOList.add(new FoodItemDTO(item.getItemId(),
                    item.getName(),
                    item.getUnitePrice(),
                    item.getCategory(),
                    item.getSrc()));
        }
        return foodItemDTOList;
    }

    @Override
    public FoodItemDTO findHighestId() {
        FoodItem lastItem = null;
        try {
            lastItem = kitchenDAO.findTopByOrderByItemIdDesc();
        } catch (Exception e){}
        return new FoodItemDTO(lastItem.getItemId());
    }

    @Override
    public void deleteFoodItem(int foodItemId) {
        kitchenDAO.delete(foodItemId);
    }

    @Override
    public MenuDTO findHighestFoodPackId() {
        Menu lastPack = null;
        try {
            lastPack = menuDAO.findTopByOrderByMenuIdDesc();
        } catch (Exception e){

        }
        return new MenuDTO(lastPack.getMenuId());
    }

    @Override
    public void saveMenuItem(MenuDTO menuDTO) {
        menuDAO.save(new Menu(
                menuDTO.getMenuId(),
                menuDTO.getName(),
                menuDTO.getType(),
                menuDTO.getPicture(),
                menuDTO.getUnitPrice()
        ));
    }

    @Override
    public List<MenuDTO> findMenuItems() {
        Iterable<Menu> menuItems = menuDAO.findAll();
        List<MenuDTO> menuDTOList = new ArrayList<>();

        for (Menu item: menuItems){
            menuDTOList.add(new MenuDTO(
                    item.getMenuId(),
                    item.getName(),
                    item.getType(),
                    item.getPicture(),
                    item.getUnitPrice()
            ));
        }
        return menuDTOList;
    }

    @Override
    public void deleteMenuItem(int menuItemId) {
        menuDAO.delete(menuItemId);
    }

    @Override
    public MenuDTO findMenuItemById(int menuItemId) {
        Menu menuItem = menuDAO.findOne(menuItemId);
        MenuDTO menuDTO = new MenuDTO(menuItem.getMenuId(),
                menuItem.getName(),
                menuItem.getType(),
                menuItem.getPicture(),
                menuItem.getUnitPrice());
        return menuDTO;
    }

    @Override
    public void saveFoodDetail(MenuDetailsDTO menuDTO) {
        menuDetailsDAO.save(new MenuDetails(
                menuDTO.getMenuID(),
                menuDTO.getFoodItemID()));
    }

    @Override
    public List<MenuDetailsDTO> findFoodItemsDetails(int menuId) {
        Iterable<MenuDetails> menuItems = menuDetailsDAO.findMenuDetailsByMenu_MenuId(menuId);

        List<MenuDetailsDTO> menuDetailsDTO = new ArrayList<>();

        for (MenuDetails item: menuItems){
            menuDetailsDTO.add(new MenuDetailsDTO(
                    item.getMenuDetailId().getMenu(),
                    item.getMenuDetailId().getFoodItem()
            ));
        }
        return menuDetailsDTO;
    }

    @Override
    public List<InventoryNoticeDTO> findWeekOrderNotice() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        java.util.Date beforeweek = cal.getTime();
        Date todaya = new Date();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByDateBetween(beforeweek,todaya);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public FoodItemDTO findFoodItemById(int itemId) {
        FoodItem foodItem = kitchenDAO.findOne(itemId);
        FoodItemDTO menuDTO = new FoodItemDTO(foodItem.getItemId(),
                foodItem.getName(),
                foodItem.getUnitePrice(),
                foodItem.getCategory(),
                foodItem.getSrc());
        return menuDTO;
    }

    @Override
    public List<RestaurantCounterOrderDetailDTO> findAllOrders() {
        Iterable<RestaurantCounterOrderDetail> all = restaurantCounterOrderDetail.findAll();
        List<RestaurantCounterOrderDetailDTO> dtos = new ArrayList<>();
        for (RestaurantCounterOrderDetail a : all) {
            dtos.add(new RestaurantCounterOrderDetailDTO(
                    a.getFoodItem().getItemId(),
                    a.getQuantity(),
                    a.getUnitePrice()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteItemFromPack(int foodItemId, int menuItemId) {
        menuDetailsDAO.deleteMenuDetailsByID(foodItemId,menuItemId);
    }

}
