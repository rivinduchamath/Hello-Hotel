package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.banquetDAO.LimitDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryNoticeDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenFoodOrderDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.*;
import lk.sliit.hotelManagement.controller.kitchenController.KitchenUtil;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.banquet.OrderLimit;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.KitchenFoodOrders;
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
    @Autowired
    KitchenFoodOrderDAO kitchenFoodOrderDAO;
    @Autowired
    LimitDAO limitDAO;
    @Autowired
    InventoryDAO inventoryDAO;

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
    public List<MenuDTO> findMenusByType(String type) {
        /*
        Iterable<Menu> menus = menuDAO.findAllByTypeEquals(type);

        List<MenuDTO> menuDTOS = new ArrayList<>();

        for (Menu item: menus){
            menuDTOS.add(new MenuDTO(
                    item.getMenuId(),
                    item.getName(),
                    item.getType(),
                    item.getPicture(),
                    item.getUnitPrice()
            ));
        }
        return menuDTOS;
         */
        return null;
    }

    @Override
    public MenuDTO findMaxMenuIdByType(String type) {
        /*
        int menu = menuDAO.findTopByMenuIdAndTypeEquals(type);
        return findMenuItemById(menu);

         */
        return null;
    }

    @Override
    public MenuDTO findMinMenuIdByType(String type) {
        //return findMenuItemById(menuDAO.findMinMenuIdByType(type));
        return null;
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

    @Override
    public void saveKitchenFoodOrder(KitchenFoodOrderDTO kitchenFoodOrderDTO) {
        int lastID = 1;
        if (kitchenFoodOrderDTO.getOrderId() == KitchenUtil.defaultID) {

            try {
                lastID = kitchenFoodOrderDAO.findTopByOrderByOrderIdDesc().getOrderId();
                lastID++;
            } catch (Exception e) {
                lastID = 1;
            }
        }
        kitchenFoodOrderDAO.save(new KitchenFoodOrders(
                lastID,
                kitchenFoodOrderDTO.getFoodItemId(),
                kitchenFoodOrderDTO.getDescription(),
                kitchenFoodOrderDTO.getAmount(),
                kitchenFoodOrderDTO.getExpectedDate()
        ));
    }

    @Override
    public void deleteKitchenFoodOrder(int id) {
        kitchenFoodOrderDAO.delete(id);
    }

    @Override
    public KitchenFoodOrderDTO loadKitchenFoodOrderById(int id) {
        KitchenFoodOrders kitchenFoodOrders = kitchenFoodOrderDAO.findOne(id);
        KitchenFoodOrderDTO kitchenFoodOrderDTO = new KitchenFoodOrderDTO(
                kitchenFoodOrders.getOrderId(),
                kitchenFoodOrders.getFoodItemId(),
                kitchenFoodOrders.getDescription(),
                kitchenFoodOrders.getAmount(),
                kitchenFoodOrders.getExpectedDate()
        );
        return kitchenFoodOrderDTO;
    }

    @Override
    public List<KitchenFoodOrderDTO> loadKitchenFoodOrderBydateAndDescription(java.sql.Date date, String  description) {
        Iterable<KitchenFoodOrders> kitchenFoodOrders = kitchenFoodOrderDAO.findTopByExpectedDateAndDescriptionEquals(date,description);
        List<KitchenFoodOrderDTO> kitchenFoodOrderDTOS = new ArrayList<>();

        for (KitchenFoodOrders item: kitchenFoodOrders){
            kitchenFoodOrderDTOS.add(new KitchenFoodOrderDTO(
                    item.getOrderId(),
                    item.getFoodItemId(),
                    item.getDescription(),
                    item.getAmount(),item.getExpectedDate()
            ));
        }
        return kitchenFoodOrderDTOS;
    }

    @Override
    public List<KitchenFoodOrderDTO> loadKitchenFoodOrderByDescription(String description) {
        return null;
    }

    @Override
    public void saveDailyMenuId(String id) {
        String[] ids = id.split(KitchenUtil.stringSeperator);
        OrderLimit oldMenu;
        int maxID;
        String[] names = { KitchenUtil.daily_B_MenuType,
                            KitchenUtil.daily_L_MenuType,
                            KitchenUtil.daily_D_MenuType};


        for (int i = 0; i < names.length; i++){

            try{

                oldMenu = limitDAO.findOrderLimitByLimitNameEquals(names[i]);
                oldMenu.setOrderLimit(Integer.parseInt(ids[i]));
                limitDAO.save(oldMenu);

            } catch (NullPointerException e){

                try{

                    maxID = limitDAO.findMaxLimitId();
                    maxID++;

                } catch (NullPointerException e1){

                    maxID = 1;

                }
                oldMenu = new OrderLimit(maxID,names[i],Integer.parseInt(ids[i]));
                limitDAO.save(oldMenu);
            }
        }

    }

    @Override
    public List<MenuDTO> getDailyMenuByType() {
        String[] names = { KitchenUtil.daily_B_MenuType,
                KitchenUtil.daily_L_MenuType,
                KitchenUtil.daily_D_MenuType};

        List<MenuDTO> menuDTOS = new ArrayList<>();

        for (int i = 0; i < names.length; i++){
            OrderLimit orderLimit = limitDAO.findOrderLimitByLimitNameEquals(names[i]);
            int id =(int)orderLimit.getOrderLimit();
            menuDTOS.add(findMenuItemById(id));
        }

        return menuDTOS;
    }

    @Override
    public void saveMenuDate(LimitDTO limitDTO) {
        int maxId;
        OrderLimit orderLimit;
        LimitDTO oldLimit;

        try {
            oldLimit = findMenuDate();
            limitDTO.setLimitId(oldLimit.getLimitId());
            orderLimit = new OrderLimit(
                    limitDTO.getLimitId(),
                    limitDTO.getLimitName(),
                    limitDTO.getLimit());
            limitDAO.save(orderLimit);

        } catch (NullPointerException e){

            try {
                maxId = limitDAO.findMaxLimitId();
                maxId++;
                limitDTO.setLimitId(maxId);
                orderLimit = new OrderLimit(
                        limitDTO.getLimitId(),
                        limitDTO.getLimitName(),
                        limitDTO.getLimit());

                limitDAO.save(orderLimit);

            } catch (NullPointerException e1){
                maxId = 1;
                limitDTO.setLimitId(maxId);
                orderLimit = new OrderLimit(
                        limitDTO.getLimitId(),
                        limitDTO.getLimitName(),
                        limitDTO.getLimit());

                limitDAO.save(orderLimit);
            }

            System.out.println(limitDTO);

        }


    }

    @Override
    public LimitDTO findMenuDate() {
        OrderLimit orderLimit = limitDAO.findOrderLimitByOrderLimitEquals(KitchenUtil.kitchenMenuDate);

        return new LimitDTO(
                orderLimit.getLimitId(),
                orderLimit.getLimitName(),
                orderLimit.getOrderLimit()
        );
    }

    @Override
    public void saveInventoryNotice(KitchenInventoryNoticeDTO inventoryNoticeDTO) {

        try {
            InventoryNotice notice = inventoryNoticeDAO.findInventoryNoticeByInventoryAndExpDateEquals(
                    inventoryNoticeDTO.getInventory(), inventoryNoticeDTO.getExpDate());
            inventoryNoticeDTO.setNoticeId(notice.getNoticeId());
            inventoryNoticeDTO.setOrderQty((inventoryNoticeDTO.getOrderQty() + notice.getOrderQty()));
        } catch (Exception e) {
        }

        inventoryNoticeDAO.save(new InventoryNotice(
                inventoryNoticeDTO.getNoticeId(),
                inventoryNoticeDTO.getDepartment(),
                inventoryNoticeDTO.getOrderQty(),
                inventoryNoticeDTO.getDate(),
                inventoryNoticeDTO.getExpDate(),
                inventoryNoticeDTO.getOrderHolder(),
                inventoryNoticeDTO.isState(),
                inventoryNoticeDTO.getInventory()

        ));
    }


    @Override
    public KitchenInventoryNoticeDTO findInventoryNotice(java.sql.Date date, int foodItemId) {
        InventoryNotice inventoryNotice = inventoryNoticeDAO.findInventoryNoticeByExpDateAndDepartmentAndInventoryEquals(date,KitchenUtil.department,foodItemId);
        return new KitchenInventoryNoticeDTO(
                inventoryNotice.getNoticeId(),
                inventoryNotice.getDepartment(),
                inventoryNotice.getOrderQty(),
                inventoryNotice.getDate(),
                inventoryNotice.getExpDate(),
                inventoryNotice.getOrderHolder(),
                inventoryNotice.isState(),
                inventoryNotice.getInventory()
        );
    }

    @Override
    public int findMaxKitchenOrderId() {
        KitchenFoodOrders kitchenFoodOrders = kitchenFoodOrderDAO.findTopByOrderByOrderIdDesc();
        return kitchenFoodOrders.getOrderId();
    }

    @Override
    public List<InventoryDTO> findKitchenInventory(String s) {
        Iterable<Inventory> all = inventoryDAO.findAllByTypeEquals(s);
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory a : all) {
            dtos.add(new InventoryDTO(
                    a.getInventoryId(),
                    a.getText(),
                    a.getDescription(),
                    a.getOrderQty(),
                    a.getType(),
                    a.getOrderLimit(),
                    a.getGetPrice(),
                    a.getSellingPrice(),
                    a.getDate()
            ));
        }
        return dtos;
    }

    @Override
    public KitchenFoodOrderDTO getExistingKitchenFoodOrder(int foodItemId, java.sql.Date expectedDate, String description) {
        KitchenFoodOrders kitchenFoodOrders = kitchenFoodOrderDAO.findKitchenFoodOrdersByExpectedDateAndFoodItemIdAndDescriptionEquals(expectedDate,foodItemId, description);
        return new KitchenFoodOrderDTO(
                kitchenFoodOrders.getOrderId(),
                kitchenFoodOrders.getDescription(),
                kitchenFoodOrders.getAmount(),
                kitchenFoodOrders.getExpectedDate()
        );
    }


}
