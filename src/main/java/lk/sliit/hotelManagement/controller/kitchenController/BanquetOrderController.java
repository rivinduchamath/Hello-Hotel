package lk.sliit.hotelManagement.controller.kitchenController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.controller.banquetController.BanquetAdd;
import lk.sliit.hotelManagement.controller.banquetController.BanquetUtil;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.LimitDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.kitchen.*;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class BanquetOrderController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @Autowired
    BanquetBO banquetBO;

    @Autowired
    InventoryBO inventoryBO;

    String alertMsg = null;

    @GetMapping("/banquetOrder")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "banquetOrder";
    }


    @GetMapping("/banquetFoodOrder")
    public String loadBanquetFoodOrderPage(Model model) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);

        List<BanquetAddDTO> banquetOrderDTOS = banquetBO.findNextBanquets();
        List<BanquetAddDTO> selected = new ArrayList<>();
        for (BanquetAddDTO item: banquetOrderDTOS){
            if (!item.getOrderState().equals(BanquetUtil.banquetStateCancel)){
                selected.add(item);
            }
        }

        model.addAttribute("confirmedBanquets", selected);

        return "kitchenBanquetFoodOrderList";
    }

    @PostMapping("/editBanquetFoodOrder")
    public String loadEditBanquetFoodOrder(Model model, @ModelAttribute BanquetAddDTO banquetAddDTO) {
        alertMsg = null;
        model = getBanquetModel(model,banquetAddDTO);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));


        return "kitchenBanquetFoodOrderManage";
    }

    @PostMapping("/addBanquetFoodOrder")
    public String addKitchenFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        BanquetAddDTO banquetAddDTO = kitchenBO.findBanquetById(kitchenFoodOrderDTO.getBanquetId());

        //check order state
        if (!kitchenFoodOrderDTO.getStateStr().equals(KitchenUtil.processingState)){

            //create inventory notice object
            InventoryNoticeDTO inventoryNoticeDTO = new InventoryNoticeDTO();
            KitchenInventoryNoticeDTO kitchenNotice;

            //set values to Inventory notice
            inventoryNoticeDTO.setDepartment(KitchenUtil.department);
            inventoryNoticeDTO.setDate(getTodaySql());
            inventoryNoticeDTO.setExpDate(kitchenFoodOrderDTO.getExpectedDate());
            inventoryNoticeDTO.setOrderHolder(SuperController.idNo);
            inventoryNoticeDTO.setState(false);
            inventoryNoticeDTO.setInventory(kitchenFoodOrderDTO.getFoodItemId());
            inventoryNoticeDTO.setOrderQty(0);

            //save data
            int noticeId  = kitchenBO.saveInventoryNotice(inventoryNoticeDTO);
            inventoryNoticeDTO.setNoticeId(noticeId);

            //set kitchenFoodOrder description
            kitchenFoodOrderDTO.setDescription(
                    kitchenFoodOrderDTO.getDescription() +
                            KitchenUtil.stringSeperator +
                            noticeId +
                            KitchenUtil.stringSeperator+kitchenFoodOrderDTO.getBanquetId());

            try{

                KitchenInventoryNoticeDTO existingNotice = kitchenBO.findInventoryNotice(
                        inventoryNoticeDTO.getExpDate(),
                        inventoryNoticeDTO.getInventoryId(),
                        inventoryNoticeDTO.isState()
                );

                try {
                    //search existing order
                    KitchenFoodOrderDTO old = kitchenBO.getExistingKitchenFoodOrder(
                            kitchenFoodOrderDTO.getFoodItemId(),
                            kitchenFoodOrderDTO.getExpectedDate(),
                            kitchenFoodOrderDTO.getDescription());

                    kitchenFoodOrderDTO.setOrderId(old.getOrderId());

                    //set amount in KitchenInventoryNotice
                    inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount() - old.getAmount());

                } catch (NullPointerException e) {
                    kitchenFoodOrderDTO.setOrderId(KitchenUtil.defaultID);
                    inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());
                }

            } catch (NullPointerException e){

                try {
                    //search existing order
                    KitchenFoodOrderDTO old = kitchenBO.getExistingKitchenFoodOrder(
                            kitchenFoodOrderDTO.getFoodItemId(),
                            kitchenFoodOrderDTO.getExpectedDate(),
                            kitchenFoodOrderDTO.getDescription());

                    kitchenFoodOrderDTO.setOrderId(old.getOrderId());

                    //set amount in KitchenInventoryNotice
                    inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());

                } catch (NullPointerException e2) {
                    kitchenFoodOrderDTO.setOrderId(KitchenUtil.defaultID);
                    inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());
                }

            }

            kitchenBO.saveInventoryNotice(inventoryNoticeDTO);
            kitchenBO.saveKitchenFoodOrder(kitchenFoodOrderDTO);

            model = getBanquetModel(model,banquetAddDTO);

        } else {
            model = getBanquetModel(model,banquetAddDTO);
            alertMsg = "Order is already confirmed.";
            model.addAttribute(KitchenUtil.alertMessageName,alertMsg);
        }



        return "kitchenBanquetFoodOrderManage";
    }

    @PostMapping("/deleteBanquetFoodOrder")
    public String deleteBanquetFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO){
        alertMsg = null;
        if (!kitchenFoodOrderDTO.getStateStr().equals(KitchenUtil.processingState)){
            //get banquet order
            BanquetAddDTO banquetAddDTO = kitchenBO.findBanquetById(kitchenFoodOrderDTO.getBanquetId());

            //get inventory
            try {
                KitchenInventoryNoticeDTO kitchenNotice = kitchenBO.findInventoryNotice(
                        kitchenFoodOrderDTO.getExpectedDate(),
                        kitchenFoodOrderDTO.getFoodItemId(),
                        false
                );

                //delete kitchen order
                kitchenBO.deleteKitchenFoodOrder(kitchenFoodOrderDTO.getOrderId());
                //delete inventory item
                if (kitchenNotice.getOrderQty() > kitchenFoodOrderDTO.getAmount()) {
                    //update quantity
                    kitchenNotice.setOrderQty(0 - kitchenFoodOrderDTO.getAmount());

                    //save notice
                    kitchenBO.saveInventoryNotice(new InventoryNoticeDTO(
                            kitchenNotice.getNoticeId(),
                            kitchenNotice.getDepartment(),
                            kitchenNotice.getOrderQty(),
                            kitchenNotice.getDate(),
                            kitchenNotice.getExpDate(),
                            SuperController.idNo,
                            kitchenNotice.isState(),
                            kitchenNotice.getInventory().getInventoryId()
                    ));
                } else if (kitchenNotice.getOrderQty() == kitchenFoodOrderDTO.getAmount()) {
                    //delete notice
                    kitchenBO.deleteInventoryNoticeById(kitchenNotice.getNoticeId());
                }

            } catch (NullPointerException e) {
                //alert intem not found
            } finally {
                model = getBanquetModel(model, banquetAddDTO);
            }
        } else {
            model.addAttribute(KitchenUtil.alertMessageName, "Order is already processing.");
        }



        return "kitchenBanquetFoodOrderManage";
    }

    public Date getTodaySql() {
        long time = System.currentTimeMillis();
        Date today = new Date(time);
        return today;
    }

    public Model getBanquetModel(Model model, BanquetAddDTO banquetAddDTO){

        model.addAttribute("alert",alertMsg);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        banquetAddDTO = kitchenBO.findBanquetById(banquetAddDTO.getOrderId());

        MenuDTO menuDTO = kitchenBO.findMenuItemById(banquetAddDTO.getMenuId());
        List<InventoryDTO> selectedItems = new ArrayList<>();
        List<InventoryDTO> inventoryItems = kitchenBO.findKitchenInventory(KitchenUtil.department);
        List<KitchenFoodOrderDTO> kitchenFoodOrderDTOS = kitchenBO.loadKitchenFoodOrderBydateAndDescription(banquetAddDTO.getDate(), KitchenUtil.banquetFoodOrderType);
        List<FoodItemDTO> foodItemsInMenu = new ArrayList<>();
        List<MenuDetailsDTO> menuDetailsDTOS = kitchenBO.findFoodItemsDetails(menuDTO.getMenuId());

        //load food items to table
        for (MenuDetailsDTO item: menuDetailsDTOS){
            foodItemsInMenu.add(kitchenBO.findFoodItemById(item.getFoodItemID()));
        }

        //load not selected orders
        if (!kitchenFoodOrderDTOS.isEmpty()) {

            //select inventory items
            for (KitchenFoodOrderDTO item: kitchenFoodOrderDTOS){
                for (InventoryDTO inventory: inventoryItems){
                    if (item.getFoodItemId() == inventory.getInventoryId()){
                        item.setItemName(inventory.getText());
                        selectedItems.add(inventory);

                        //set state
                        String[] strArry = item.getDescription().split(KitchenUtil.stringSeperator);
                        if (strArry[0].equals(KitchenUtil.confimedBanquet)){
                            item.setStateStr(KitchenUtil.processingState);
                            item.setState(false);
                        } else if (strArry[0].equals(KitchenUtil.banquetFoodOrderType)){
                            item.setStateStr(KitchenUtil.pendingState);
                            item.setState(true);
                        }
                    }
                }
            }

            //not selected list generate
            for (InventoryDTO selected: selectedItems){
                if (inventoryItems.contains(selected))
                    inventoryItems.remove(selected);
            }

        }


        model.addAttribute("menu", menuDTO);
        model.addAttribute("banquetOrder", banquetAddDTO);
        model.addAttribute("loadOrderTable", kitchenFoodOrderDTOS);
        model.addAttribute("loadFoodItemsTable", inventoryItems);
        model.addAttribute("loadFoodItemsInMenuTable", foodItemsInMenu);
        model.addAttribute("banquetOrderType", KitchenUtil.banquetFoodOrderType);

        return model;
    }

}
