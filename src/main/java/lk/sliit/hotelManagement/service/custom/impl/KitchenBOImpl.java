package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.controller.banquetController.BanquetAdd;
import lk.sliit.hotelManagement.dao.banquetDAO.BanquetOrderDAO;
import lk.sliit.hotelManagement.dao.banquetDAO.LimitDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryNoticeDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenFoodOrderDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.*;
import lk.sliit.hotelManagement.controller.kitchenController.KitchenUtil;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import lk.sliit.hotelManagement.entity.banquet.OrderLimit;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.KitchenFoodOrders;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
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
    @Autowired
    BanquetOrderDAO banquetOrderDAO;
    @Autowired
    RestaurantCounterOrderDAO counterOrderDAO;
    @Autowired
    RestaurantOnlineOrderDAO onlineOrderDAO;

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
    public List<FoodItemDTO> findFoodItems() {//Find all Kitchen Foods
        Iterable<FoodItem> foodItems = kitchenDAO.findAll();//call to crud repo
        List<FoodItemDTO> foodItemDTOList = new ArrayList<>();

        for (FoodItem item : foodItems) {
            foodItemDTOList.add(new FoodItemDTO(
                    item.getItemId(),
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
        } catch (Exception e) {
        }
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
        } catch (Exception e) {

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

        for (Menu item : menuItems) {
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

        //setprice
        Menu item = menuDAO.findOne(menuDTO.getMenuID());
        item.setUnitPrice(item.getUnitPrice() + kitchenDAO.findOne(menuDTO.getFoodItemID()).getUnitePrice());
        menuDAO.save(item);
    }

    @Override
    public List<MenuDetailsDTO> findFoodItemsDetails(int menuId) {
        Iterable<MenuDetails> menuItems = menuDetailsDAO.findMenuDetailsByMenu_MenuId(menuId);

        List<MenuDetailsDTO> menuDetailsDTO = new ArrayList<>();

        for (MenuDetails item : menuItems) {
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
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByDateBetween(beforeweek, todaya);
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
        //update price
        Menu item = menuDAO.findOne(menuItemId);
        FoodItem foodItem = kitchenDAO.findOne(foodItemId);
        item.setUnitPrice(item.getUnitPrice() - foodItem.getUnitePrice());
        menuDetailsDAO.deleteMenuDetailsByFoodItemAndMenuEquals(foodItem, item);

        //save menu
        menuDAO.save(item);
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
        } else {
            lastID = kitchenFoodOrderDTO.getOrderId();
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
    public List<KitchenFoodOrderDTO> loadKitchenFoodOrderBydateAndDescription(java.sql.Date date, String description) {
        List<KitchenFoodOrderDTO> returnList = new ArrayList<>();
        Iterable<KitchenFoodOrders> kitchenFoodOrders = kitchenFoodOrderDAO.findAllByExpectedDateAndDescriptionStartsWith(date, description);

        for (KitchenFoodOrders item : kitchenFoodOrders) {
            returnList.add(new KitchenFoodOrderDTO(
                    item.getOrderId(),
                    item.getFoodItemId(),
                    item.getDescription(),
                    item.getAmount(),
                    item.getExpectedDate()
            ));
        }
        if (description.equals(KitchenUtil.banquetFoodOrderType)) {

            kitchenFoodOrders = kitchenFoodOrderDAO.findAllByExpectedDateAndDescriptionStartsWith(date, KitchenUtil.confimedBanquet);
            for (KitchenFoodOrders item : kitchenFoodOrders) {
                returnList.add(new KitchenFoodOrderDTO(
                        item.getOrderId(),
                        item.getFoodItemId(),
                        item.getDescription(),
                        item.getAmount(),
                        item.getExpectedDate()
                ));
            }
        }


        return returnList;
    }

    @Override
    public List<KitchenFoodOrderDTO> findAllKitchenFoodOrders() {
        List<KitchenFoodOrderDTO> orders = new ArrayList<>();
        Iterable<KitchenFoodOrders> foodOrders = kitchenFoodOrderDAO.findAll();

        for (KitchenFoodOrders item : foodOrders) {
            orders.add(new KitchenFoodOrderDTO(
                    item.getOrderId(),
                    item.getFoodItemId(),
                    item.getDescription(),
                    item.getAmount(),
                    item.getExpectedDate()
            ));
        }
        return orders;
    }

    @Override
    public void saveDailyMenuId(String id) {
        String[] ids = id.split(KitchenUtil.stringSeperator);
        OrderLimit oldMenu;
        int maxID;
        String[] names = {KitchenUtil.daily_B_MenuType,
                KitchenUtil.daily_L_MenuType,
                KitchenUtil.daily_D_MenuType};


        for (int i = 0; i < names.length; i++) {

            try {

                oldMenu = limitDAO.findOrderLimitByLimitNameEquals(names[i]);
                oldMenu.setOrderLimit(Integer.parseInt(ids[i]));
                limitDAO.save(oldMenu);

            } catch (NullPointerException e) {

                try {

                    maxID = limitDAO.findMaxLimitId();
                    maxID++;

                } catch (NullPointerException e1) {

                    maxID = 1;

                }
                oldMenu = new OrderLimit(maxID, names[i], Integer.parseInt(ids[i]));
                limitDAO.save(oldMenu);
            }
        }

    }

    @Override
    public List<MenuDTO> getDailyMenuByType() {
        String[] names = {KitchenUtil.daily_B_MenuType,
                KitchenUtil.daily_L_MenuType,
                KitchenUtil.daily_D_MenuType};

        List<MenuDTO> menuDTOS = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            OrderLimit orderLimit = limitDAO.findOrderLimitByLimitNameEquals(names[i]);
            int id = (int) orderLimit.getOrderLimit();
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

        } catch (NullPointerException e) {

            try {
                maxId = limitDAO.findMaxLimitId();
                maxId++;
                limitDTO.setLimitId(maxId);
                orderLimit = new OrderLimit(
                        limitDTO.getLimitId(),
                        limitDTO.getLimitName(),
                        limitDTO.getLimit());

                limitDAO.save(orderLimit);

            } catch (NullPointerException e1) {
                maxId = 1;
                limitDTO.setLimitId(maxId);
                orderLimit = new OrderLimit(
                        limitDTO.getLimitId(),
                        limitDTO.getLimitName(),
                        limitDTO.getLimit());

                limitDAO.save(orderLimit);
            }

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
    public int saveInventoryNotice(InventoryNoticeDTO inventoryNoticeDTO) {

        try {
            InventoryNotice notice = inventoryNoticeDAO.findInventoryNoticeByExpDateAndDepartmentAndInventoryAndStateEquals(
                    inventoryNoticeDTO.getExpDate(),
                    inventoryNoticeDTO.getDepartment(),
                    inventoryDAO.findOne(inventoryNoticeDTO.getInventory()),
                    inventoryNoticeDTO.isState());

            inventoryNoticeDTO.setNoticeId(notice.getNoticeId());
            inventoryNoticeDTO.setOrderQty((inventoryNoticeDTO.getOrderQty() + notice.getOrderQty()));

        } catch (Exception e) {
            int id = 1;

            try {
                id = inventoryNoticeDAO.findTopByOrderByNoticeIdDesc().getNoticeId();
                id++;
                inventoryNoticeDTO.setNoticeId(id);
            } catch (NullPointerException e1) {
                id = 1;
                inventoryNoticeDTO.setNoticeId(id);
            }
        }

        inventoryNoticeDAO.save(new InventoryNotice(
                inventoryNoticeDTO.getNoticeId(),
                inventoryNoticeDTO.getDepartment(),
                inventoryNoticeDTO.getOrderQty(),
                inventoryNoticeDTO.getDate(),
                inventoryNoticeDTO.getExpDate(),
                inventoryNoticeDTO.getOrderHolder(),
                inventoryNoticeDTO.isState(),
                inventoryDAO.findOne(inventoryNoticeDTO.getInventory())

        ));

        return inventoryNoticeDTO.getNoticeId();
    }

    @Override
    public void deleteInventoryNoticeById(int id) {
        inventoryNoticeDAO.delete(id);
    }

    @Override
    public KitchenInventoryNoticeDTO findInventoryNotice(java.sql.Date date, int foodItemId, boolean state) {

        InventoryNotice inventoryNotice = inventoryNoticeDAO.findInventoryNoticeByExpDateAndDepartmentAndInventoryAndStateEquals(date, KitchenUtil.department, inventoryDAO.findOne(foodItemId), state);

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
    public int findInventoryNoticeId() {

        return inventoryNoticeDAO.findTopByOrderByNoticeIdDesc().getNoticeId();
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
    public void whenNoticeConfirmed(int noticeId) {
        List<KitchenFoodOrderDTO> orders = findAllKitchenFoodOrders();

        for (KitchenFoodOrderDTO item : orders) {
            String[] strArry = item.getDescription().split(KitchenUtil.stringSeperator);

            if (Integer.parseInt(strArry[1]) == noticeId && strArry[0].equals(KitchenUtil.dailyFoodOrderType)) {
                kitchenFoodOrderDAO.delete(item.getOrderId());
            } else if (Integer.parseInt(strArry[1]) == noticeId && strArry[0].equals(KitchenUtil.banquetFoodOrderType)) {
                item.setDescription(KitchenUtil.confimedBanquet + KitchenUtil.stringSeperator + strArry[1]);
                kitchenFoodOrderDAO.save(new KitchenFoodOrders(
                        item.getOrderId(),
                        item.getFoodItemId(),
                        item.getDescription(),
                        item.getAmount(),
                        item.getExpectedDate()
                ));
            }
        }
    }

    @Override
    public KitchenFoodOrderDTO getExistingKitchenFoodOrder(int foodItemId, java.sql.Date expectedDate, String description) {
        KitchenFoodOrders kitchenFoodOrders = kitchenFoodOrderDAO.findKitchenFoodOrdersByExpectedDateAndFoodItemIdAndDescriptionEquals(expectedDate, foodItemId, description);

        return new KitchenFoodOrderDTO(
                kitchenFoodOrders.getOrderId(),
                kitchenFoodOrders.getFoodItemId(),
                kitchenFoodOrders.getDescription(),
                kitchenFoodOrders.getAmount(),
                kitchenFoodOrders.getExpectedDate()
        );
    }

    @Override
    public BanquetAddDTO findBanquetById(int id) {
        BanquetOrder banquetOrder = banquetOrderDAO.findOne(id);
        return new BanquetAddDTO(
                banquetOrder.getOrderId(),
                banquetOrder.getDate(),
                banquetOrder.getHallId(),
                banquetOrder.getNoOfPlates(),
                banquetOrder.getMenu().getMenuId()
        );
    }

    @Override
    public void whenBanquetCancelled(int id) {
        BanquetOrder banquet = banquetOrderDAO.findOne(id);
        Iterable<KitchenFoodOrders> orders = kitchenFoodOrderDAO.findAllByExpectedDateAndDescriptionStartsWith(banquet.getDate(), KitchenUtil.banquetFoodOrderType);

        for (KitchenFoodOrders item : orders) {
            String[] strArry = item.getDescription().split(KitchenUtil.stringSeperator);

            if (id == Integer.parseInt(strArry[2])) {
                kitchenFoodOrderDAO.delete(item.getOrderId());
                InventoryNotice inventoryNotice = inventoryNoticeDAO.findOne(Integer.parseInt(strArry[1]));

                if (!inventoryNotice.isState()) {
                    if (item.getAmount() < inventoryNotice.getOrderQty()) {
                        inventoryNotice.setOrderQty(inventoryNotice.getOrderQty() - item.getAmount());
                        inventoryNoticeDAO.save(inventoryNotice);
                    } else if (item.getAmount() == inventoryNotice.getOrderQty()) {
                        inventoryNoticeDAO.delete(inventoryNotice.getNoticeId());
                    }
                }

            }
        }
    }

    @Override
    public List<RestaurantFoodOrderDTO> getOnlineRestaurantFoodOrdersByDate(Date date) {
        List<RestaurantFoodOrderDTO> returnList = new ArrayList<>();
        List<RestaurantFoodItemDTO> foodItemDTOS;
        Iterable<RestaurantOnlineOrder> onlineOrders;
        int index = 0;

        //get counter orders
        try {
            onlineOrders = onlineOrderDAO.findAll();

            for (RestaurantOnlineOrder item : onlineOrders) {
                Date comp = item.getDate();
                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {

                    if (item.getOrderState() == null
                            || item.getOrderState().equals(KitchenUtil.pendingState)
                            || item.getOrderState().equals(KitchenUtil.processingState)) {

                        //set state and button
                        String button = KitchenUtil.pendingState;

                        if (index == 0) {
                            button = KitchenUtil.accept;
                        }

                        if (item.getOrderState() == null) {
                            item.setOrderState(KitchenUtil.pendingState);
                        }

                        if (item.getOrderState().equals(KitchenUtil.processingState)) {
                            button = KitchenUtil.confirm;
                        }

                        Iterable<RestaurantOnlineOrderDetails> onlineOrderDetails = onlineOrderDetailsDAO.findAllByRestaurantOnlineOrderEquals(item);

                        //create food item list
                        foodItemDTOS = new ArrayList<>();

                        for (RestaurantOnlineOrderDetails detail : onlineOrderDetails) {
                            //set food items list
                            foodItemDTOS.add(new RestaurantFoodItemDTO(
                                    detail.getFoodItem().getItemId(),
                                    item.getOrderId(),
                                    detail.getFoodItem().getName(),
                                    detail.getQuantity(),
                                    detail.getUnitePrice()
                            ));
                        }

                        //complete restaurant food order
                        returnList.add(new RestaurantFoodOrderDTO(
                                item.getOrderId(),
                                KitchenUtil.onlineType,
                                item.getOrderState(),
                                button,
                                foodItemDTOS,
                                index
                        ));

                        index++;

                    }


                }

            }
        } catch (NullPointerException e) {

        }

        return returnList;
    }

    @Override
    public List<RestaurantFoodOrderDTO> getCounterRestaurantFoodOrdersByDate(Date date) {

        List<RestaurantFoodOrderDTO> returnList = new ArrayList<>();
        List<RestaurantFoodItemDTO> foodItemDTOS;
        Iterable<RestaurantCounterOrder> counterOrders;
        int index = 0;
        //get counter orders
        try {
            counterOrders = counterOrderDAO.findAll();

            for (RestaurantCounterOrder item : counterOrders) {

                Date comp = item.getDate();
                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {
                    if (item.getOrderState() == null
                            || item.getOrderState().equals(KitchenUtil.pendingState)
                            || item.getOrderState().equals(KitchenUtil.processingState)) {
                        //set state and button
                        String button = KitchenUtil.pendingState;

                        if (index == 0) {
                            button = KitchenUtil.accept;
                        }

                        if (item.getOrderState() == null) {
                            item.setOrderState(KitchenUtil.pendingState);
                        }

                        if (item.getOrderState().equals(KitchenUtil.processingState)) {
                            button = KitchenUtil.confirm;
                        }


                        Iterable<RestaurantCounterOrderDetail> counterOrderDetails = restaurantCounterOrderDetail.findAllByRestaurantCounterOrderEquals(item);

                        //create food item list
                        foodItemDTOS = new ArrayList<>();

                        for (RestaurantCounterOrderDetail detail : counterOrderDetails) {
                            //set food items list
                            foodItemDTOS.add(new RestaurantFoodItemDTO(
                                    detail.getFoodItem().getItemId(),
                                    item.getOrderId(),
                                    detail.getFoodItem().getName(),
                                    detail.getQuantity(),
                                    detail.getUnitePrice()
                            ));
                        }

                        //complete restaurant food order
                        returnList.add(new RestaurantFoodOrderDTO(
                                item.getOrderId(),
                                KitchenUtil.counterType,
                                item.getOrderState(),
                                button,
                                foodItemDTOS,
                                index
                        ));

                        index++;

                    }

                }

            }
        } catch (NullPointerException e) {

        }

        return returnList;
    }

    @Override
    public boolean takeRestaurantOrder(RestaurantFoodOrderDTO order) {

        //check order type
        if (order.getType().equals(KitchenUtil.onlineType)) {
            RestaurantOnlineOrder onlineOrder = onlineOrderDAO.findOne(order.getOrderId());

            //check state
            if (!onlineOrder.getOrderState().equals(KitchenUtil.canceledState)
                    || !onlineOrder.getOrderState().equals(KitchenUtil.finishedState)) {
                onlineOrder.setOrderState(KitchenUtil.processingState);
                onlineOrderDAO.save(onlineOrder);
                return true;
            }

        } else if (order.getType().equals(KitchenUtil.counterType)) {
            RestaurantCounterOrder counterOrder = counterOrderDAO.findOne(order.getOrderId());

            //check state
            if (!counterOrder.getOrderState().equals(KitchenUtil.canceledState)
                    || !counterOrder.getOrderState().equals(KitchenUtil.finishedState)) {
                counterOrder.setOrderState(KitchenUtil.processingState);
                counterOrderDAO.save(counterOrder);

                return true;
            }
        }
        return false;
    }

    @Override
    public void confirmRestaurantOrder(RestaurantFoodOrderDTO orderDTO) {

        if (orderDTO.getType().equals(KitchenUtil.onlineType)) {
            RestaurantOnlineOrder onlineOrder = onlineOrderDAO.findOne(orderDTO.getOrderId());
            onlineOrder.setOrderState(KitchenUtil.finishedState);
            onlineOrderDAO.save(onlineOrder);

        } else if (orderDTO.getType().equals(KitchenUtil.counterType)) {
            RestaurantCounterOrder counterOrder = counterOrderDAO.findOne(orderDTO.getOrderId());
            counterOrder.setOrderState(KitchenUtil.finishedState);
            counterOrderDAO.save(counterOrder);
        }

    }

    @Override
    public List<RestaurantFoodOrderDTO> findReportData(Date date) {
        //load online finished orders
        List<RestaurantFoodOrderDTO> returnlist = new ArrayList<>();
        List<RestaurantFoodItemDTO> foodItemDTOS, selectedList;
        RestaurantFoodOrderDTO order;

        try {
            Iterable<RestaurantOnlineOrder> onlineOrders = onlineOrderDAO.findAllByOrderStateEquals(KitchenUtil.finishedState);
            foodItemDTOS = new ArrayList<>();
            selectedList = new ArrayList<>();

            for (RestaurantOnlineOrder item : onlineOrders) {
                Date comp = item.getDate();

                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {

                    //load order details
                    Iterable<RestaurantOnlineOrderDetails> details = onlineOrderDetailsDAO.findAllByRestaurantOnlineOrderEquals(item);
                    for (RestaurantOnlineOrderDetails detail : details) {

                        foodItemDTOS.add(new RestaurantFoodItemDTO(
                                detail.getFoodItem().getItemId(),
                                item.getOrderId(),
                                detail.getFoodItem().getName(),
                                detail.getQuantity(),
                                detail.getUnitePrice()
                        ));

                    }

                }

            }

            System.out.println("==========================================================");
            for (RestaurantFoodItemDTO item:foodItemDTOS){
                System.out.println(item.getFoodItemId());
                System.out.println(item.getFoodName());
                System.out.println("--------------------");
            }

            //set food item list

            if (!foodItemDTOS.isEmpty()){

                while (!foodItemDTOS.isEmpty()){
                    //select 1st item
                    RestaurantFoodItemDTO selectedItem = foodItemDTOS.get(0);
                    selectedItem.setQuantity(0);

                    int index = 0;
                    List<Integer> indexes = new ArrayList<>();
                    //get total food item info
                    if (!foodItemDTOS.isEmpty()){

                        for (RestaurantFoodItemDTO item:foodItemDTOS){
                            if (selectedItem.getFoodItemId() == item.getFoodItemId()){
                                selectedItem.setQuantity(item.getQuantity() + selectedItem.getQuantity());
                                indexes.add(index);
                            }

                            index++;
                        }

                        //remove selected item from foodItemDTOS
                        for (Integer item: indexes){
                            foodItemDTOS.remove(item);
                        }

                        selectedList.add(selectedItem);

                    }
                }

                //set total price
                for (RestaurantFoodItemDTO item:selectedList){
                    item.setTotalPrice(item.getQuantity() * item.getPrice());
                }
            }

            order = new RestaurantFoodOrderDTO();
            order.setFoodItems(selectedList);
            order.setType(KitchenUtil.onlineType);
            returnlist.add(order);

        } catch (
                NullPointerException e) {
        }

        //load counter finished orders
        try {
            Iterable<RestaurantCounterOrder> coubterOrders = counterOrderDAO.findAllByOrderStateEquals(KitchenUtil.finishedState);
            foodItemDTOS = new ArrayList<>();
            selectedList = new ArrayList<>();

            for (RestaurantCounterOrder item : coubterOrders) {
                Date comp = item.getDate();

                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {

                    //load order details
                    Iterable<RestaurantCounterOrderDetail> details = restaurantCounterOrderDetail.findAllByRestaurantCounterOrderEquals(item);

                    for (RestaurantCounterOrderDetail detail : details) {

                        foodItemDTOS.add(new RestaurantFoodItemDTO(
                                detail.getFoodItem().getItemId(),
                                item.getOrderId(),
                                detail.getFoodItem().getName(),
                                detail.getQuantity(),
                                detail.getUnitePrice()
                        ));

                    }

                }
            }
            System.out.println("==========================================================");
            for (RestaurantFoodItemDTO item:foodItemDTOS){
                System.out.println(item.getFoodItemId());
                System.out.println(item.getFoodName());
                System.out.println("--------------------");
            }

            //set food item list
            if (!foodItemDTOS.isEmpty()){

                while (!foodItemDTOS.isEmpty()){
                    //select 1st item
                    RestaurantFoodItemDTO selectedItem = foodItemDTOS.get(0);
                    selectedItem.setQuantity(0);

                    int index = 0;
                    List<Integer> indexes = new ArrayList<>();
                    //get total food item info
                    if (!foodItemDTOS.isEmpty()){

                        for (RestaurantFoodItemDTO item:foodItemDTOS){
                            if (selectedItem.getFoodItemId() == item.getFoodItemId()){
                                selectedItem.setQuantity(item.getQuantity() + selectedItem.getQuantity());
                                indexes.add(index);
                            }

                            index++;
                        }

                        //remove selected item from foodItemDTOS
                        for (Integer item: indexes){
                            foodItemDTOS.remove(item);
                        }

                        selectedList.add(selectedItem);

                    }
                }

                //set total price
                for (RestaurantFoodItemDTO item:selectedList){
                    item.setTotalPrice(item.getQuantity() * item.getPrice());
                }

            }
            order = new RestaurantFoodOrderDTO();
            order.setType(KitchenUtil.counterType);
            order.setFoodItems(selectedList);
            returnlist.add(order);

        } catch (
                NullPointerException e) {
        }

        return returnlist;
    }


}
