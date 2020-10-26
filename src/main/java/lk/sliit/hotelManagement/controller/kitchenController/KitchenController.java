package lk.sliit.hotelManagement.controller.kitchenController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.*;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Controller
public class KitchenController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @Autowired
    InventoryBO inventoryBO;

    @GetMapping("/kitchen")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<InventoryDTO> inventoryItems = kitchenBO.findKitchenInventory(KitchenUtil.department);
        List<KitchenFoodOrderDTO> kitchenFoodOrderDTOS = kitchenBO.loadKitchenFoodOrderBydateAndDescription(getTodaySql(), KitchenUtil.dailyFoodOrderType);
        List<FoodItemDTO> breakfastFoodItems, lunchFoodItems, dinnerFoodItems;
        List<MenuDTO> menuDTOS = kitchenBO.findMenuItems();
        MenuDTO breakfast, lunch, dinner;
        LimitDTO limitDTO = new LimitDTO();
        InventoryDTO inventoryDTO;

        //load not selected orders
        if (!kitchenFoodOrderDTOS.isEmpty()){

            for (KitchenFoodOrderDTO item : kitchenFoodOrderDTOS){

                for (int i = 0; i < inventoryItems.size(); i++){
                    inventoryDTO = inventoryItems.remove(i);

                    if (inventoryDTO.getInventoryId() == item.getFoodItemId()){
                        break;
                    } else {
                        inventoryItems.add(inventoryDTO);
                    }
                }

            }

            for (KitchenFoodOrderDTO item: kitchenFoodOrderDTOS){
                item.setItemName(inventoryBO.findFoodItemById(item.getFoodItemId()).getText());
            }
        }

        limitDTO.setLimit(KitchenUtil.kitchenMenuDate);

        //set default MenuDTO objects
        breakfast = getDefultMenu();
        breakfast.setType(KitchenUtil.daily_B_MenuType);
        lunch = getDefultMenu();
        lunch.setType(KitchenUtil.daily_L_MenuType);
        dinner = getDefultMenu();
        dinner.setType(KitchenUtil.daily_D_MenuType);


        //load daily menus block
        try {
            //Get saved
            String[] menudateArr = kitchenBO.findMenuDate().getLimitName().split(KitchenUtil.stringSeperator);
            String oldMenuDate = menudateArr[1];

            //compare today and saved date
            if (compareDateWithToday(Date.valueOf(oldMenuDate))) {
                //new date
                limitDTO.setLimitName(KitchenUtil.department + KitchenUtil.stringSeperator + getDateTodayString());
                kitchenBO.saveMenuDate(limitDTO);

                try {
                    List<MenuDTO> oldMenus = kitchenBO.getDailyMenuByType();
                    breakfast = oldMenus.get(0);
                    lunch = oldMenus.get(1);
                    dinner = oldMenus.get(2);
                } catch (NullPointerException e) {
                }

                //get next items
                breakfast = getNextItem(menuDTOS, breakfast);
                lunch = getNextItem(menuDTOS, lunch);
                dinner = getNextItem(menuDTOS, dinner);


                //generate key string
                String menusKey = breakfast.getMenuId() + KitchenUtil.stringSeperator + lunch.getMenuId() + KitchenUtil.stringSeperator + dinner.getMenuId();
                //save new daily menus
                kitchenBO.saveDailyMenuId(menusKey);

            } else {
                //get saved menus
                List<MenuDTO> menus = kitchenBO.getDailyMenuByType();
                breakfast = menus.get(0);
                lunch = menus.get(1);
                dinner = menus.get(2);
            }
        } catch (NullPointerException e) {
            //saved date not found
            //save today
            limitDTO.setLimitName(KitchenUtil.department + KitchenUtil.stringSeperator + getDateTodayString());
            kitchenBO.saveMenuDate(limitDTO);

            try {
                List<MenuDTO> oldMenus = kitchenBO.getDailyMenuByType();
                breakfast = oldMenus.get(0);
                lunch = oldMenus.get(1);
                dinner = oldMenus.get(2);
            } catch (NullPointerException e2) {
                breakfast = getNextItem(menuDTOS,breakfast);
                lunch = getNextItem(menuDTOS,lunch);
                dinner = getNextItem(menuDTOS,dinner);
            }

            //generate key string
            String menusKey = breakfast.getMenuId() + KitchenUtil.stringSeperator + lunch.getMenuId() + KitchenUtil.stringSeperator + dinner.getMenuId();
            //save new daily menus
            kitchenBO.saveDailyMenuId(menusKey);

        }

        breakfastFoodItems = getMenuFoodItems(breakfast);
        lunchFoodItems = getMenuFoodItems(lunch);
        dinnerFoodItems = getMenuFoodItems(dinner);


        // set model attributes

        model.addAttribute("loadFoodItemTable", inventoryItems);
        model.addAttribute("loadOrderTable", kitchenFoodOrderDTOS);
        model.addAttribute("breakfast", breakfast);
        model.addAttribute("breakfastTable", breakfastFoodItems);
        model.addAttribute("lunch", lunch);
        model.addAttribute("lunchTable", lunchFoodItems);
        model.addAttribute("dinner", dinner);
        model.addAttribute("dinnerTable", dinnerFoodItems);
        model.addAttribute("dailyOrderType", KitchenUtil.dailyFoodOrderType);

        return "kitchen";
    }

    @PostMapping("/kitchen")
    public void addDailyKitchenFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //create inventory notice object
        KitchenInventoryNoticeDTO inventoryNoticeDTO = new KitchenInventoryNoticeDTO();
        InventoryDTO inventoryDTO;

        try {

            inventoryDTO = inventoryBO.findInventory(kitchenFoodOrderDTO.getFoodItemId());

            //set Inventory entity object
            Inventory inventory = new Inventory(
                    inventoryDTO.getInventoryId(),
                    inventoryDTO.getText(),
                    inventoryDTO.getDescription(),
                    inventoryDTO.getOrderQty(),
                    inventoryDTO.getType(),
                    inventoryDTO.getOrderLimit(),
                    inventoryDTO.getGetPrice(),
                    inventoryDTO.getSellingPrice(),
                    inventoryDTO.getDate()
            );

            //set notice id
            int maxId = 1;
            try {
                maxId = inventoryBO.findHighestId().getInventoryId();//error*********************************************
                maxId++;
            } catch (NullPointerException e){
                maxId = 1;
            }

            inventoryNoticeDTO.setNoticeId(maxId);
            inventoryNoticeDTO.setDepartment(KitchenUtil.department);
            inventoryNoticeDTO.setDate(getTodaySql());
            inventoryNoticeDTO.setExpDate(kitchenFoodOrderDTO.getExpectedDate());
            inventoryNoticeDTO.setOrderHolder(SuperController.idNo);
            inventoryNoticeDTO.setState(false);
            inventoryNoticeDTO.setInventory(inventory);


            //search existing order
            try{
                KitchenFoodOrderDTO old = kitchenBO.getExistingKitchenFoodOrder(kitchenFoodOrderDTO.getFoodItemId(),
                                                                kitchenFoodOrderDTO.getExpectedDate(),
                                                                kitchenFoodOrderDTO.getDescription());

                //set amount in KitchenInventoryNotice
                inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount() - old.getAmount());
                maxId = old.getOrderId();

            } catch (NullPointerException e){
                maxId = KitchenUtil.defaultID;
                inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());
            }
            kitchenFoodOrderDTO.setOrderId(maxId);

            kitchenBO.saveInventoryNotice(inventoryNoticeDTO);
            kitchenBO.saveKitchenFoodOrder(kitchenFoodOrderDTO);

        } catch (NullPointerException e){
            //alert inventory object not found
        }





        loginPage(model);
    }

    @PostMapping("/kitchen")
    public void deleteDailyOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO){

        try{
            //InventoryNoticeDTO inventoryNoticeDTO = kitchenBO.findInventoryNotice(kitchenFoodOrderDTO.getExpectedDate(),kitchenFoodOrderDTO.getFoodItemId());

        } catch (NullPointerException e){

        }
    }


    @GetMapping("/kitchenReport")
    public String loadKitchenReport(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "kitchenReport";
    }

    @GetMapping("/restaurantOrders")
    public String loadRestaurantOrders(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "kitchenRestaurantOrderList";
    }

    public Date getTodaySql() {
        long time = System.currentTimeMillis();
        Date today = new Date(time);
        return today;
    }

    public boolean compareDateWithToday(Date date) {
        Date today = Date.valueOf(getDateTodayString());
        if (date.compareTo(today) < 0) {
            return true;
        }
        return false;
    }

    private String getDateTodayString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String today = dateFormat.format(date);
        return today;
    }

    public List<FoodItemDTO> getMenuFoodItems(MenuDTO menu) {

        List<MenuDetailsDTO> menuDetails;
        List<FoodItemDTO> foodItems = new ArrayList<>();
        FoodItemDTO defaultFoodItem;
        if (menu.getMenuId() != KitchenUtil.defaultID) {
            menuDetails = kitchenBO.findFoodItemsDetails(menu.getMenuId());

            for (MenuDetailsDTO item : menuDetails) {
                foodItems.add(kitchenBO.findFoodItemById(item.getFoodItemID()));
            }
        } else {
            defaultFoodItem = new FoodItemDTO();
            defaultFoodItem.setItemName(KitchenUtil.emptyItemList);
            foodItems.add(defaultFoodItem);
        }

        return foodItems;
    }

    public MenuDTO getNextItem(List<MenuDTO> menuDTOS, MenuDTO key) {
        MenuDTO returnItem = key;
        MenuDTO save = key;
        Queue<MenuDTO> queue = new LinkedList<>();
        int index = 0;

        //create list
        if (!menuDTOS.isEmpty()) {
            for (MenuDTO item : menuDTOS) {
                if (item.getType().equals(key.getType())) {
                    queue.add(item);
                }
            }
        }


        //remove unwanted
        if (key.getMenuId() != KitchenUtil.defaultID && !queue.isEmpty()) {

            while (!queue.isEmpty()) {

                returnItem = queue.remove();

                index++;
                if (index == 1) {
                    save = returnItem;

                }

                if (returnItem.getMenuId() == key.getMenuId()) {
                    //get next item
                    if (!queue.isEmpty()) {
                        returnItem = queue.remove();
                    } else {
                        returnItem = save;
                    }
                    break;
                }

            }

        } else if (key.getMenuId() == KitchenUtil.defaultID && !queue.isEmpty()) {
            returnItem = queue.remove();
        } else if (queue.isEmpty()) {
            returnItem = key;
        }

        return returnItem;
    }

    public FoodItemDTO getDefaultFoodItem() {
        FoodItemDTO defaultFoodItem = new FoodItemDTO();
        defaultFoodItem.setItemId(KitchenUtil.defaultID);
        defaultFoodItem.setItemName(KitchenUtil.emptyFoodItem);
        return defaultFoodItem;
    }

    public MenuDTO getDefultMenu() {
        MenuDTO defaultMenu = new MenuDTO();
        defaultMenu.setMenuId(KitchenUtil.defaultID);
        defaultMenu.setName(KitchenUtil.emptyMenuName);
        return defaultMenu;
    }

}
