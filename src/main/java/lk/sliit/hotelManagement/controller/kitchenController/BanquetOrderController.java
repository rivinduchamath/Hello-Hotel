package lk.sliit.hotelManagement.controller.kitchenController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.KitchenFoodOrderDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import lk.sliit.hotelManagement.service.custom.impl.FoodAndBeverageBOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @GetMapping("/banquetOrder")
    public String loginPage(Model model)
    {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "banquetOrder";
    }


    @GetMapping("/banquetFoodOrder")
    public String loadBanquetFoodOrderPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<BanquetAddDTO> banquetOrderDTOS = banquetBO.findConfirmedBanquet();
        model.addAttribute("confirmedBanquets", banquetOrderDTOS);

        return "kitchenBanquetFoodOrderList";
    }

    @PostMapping("/editBanquetFoodOrder")
    public String loadEditBanquetFoodOrder(Model model, @ModelAttribute BanquetAddDTO banquetAddDTO){

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        MenuDTO menuDTO = kitchenBO.findMenuItemById(banquetAddDTO.getMenuId());
        List<MenuDetailsDTO> menuDetailsDTOS = kitchenBO.findFoodItemsDetails(banquetAddDTO.getMenuId());
        List<FoodItemDTO> allFoodItems = kitchenBO.findFoodItemsForMenu();
        List<FoodItemDTO> allIngredients = kitchenBO.findFoodIngredient();
        List<FoodItemDTO> foodItemDTOS = new ArrayList<>();

        if (menuDetailsDTOS.size() != 0){
            for (MenuDetailsDTO item: menuDetailsDTOS){

                for (FoodItemDTO foodItem: allFoodItems){
                    if (item.getFoodItemID() == foodItem.getItemId()){
                        foodItemDTOS.add(foodItem);
                    }
                }

            }
        }

        model.addAttribute("menu", menuDTO);
        model.addAttribute("banquetOrder", banquetAddDTO);
        model.addAttribute("loadFoodItemsInMenuTable", foodItemDTOS);
        model.addAttribute("loadFoodItemsTable", allIngredients);

        return "kitchenBanquetFoodOrderManage";
    }

    @PostMapping("/addKitchenFoodOrder")
    public String addKitchenFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("menu", kitchenBO.findFoodItemById(Integer.parseInt(kitchenFoodOrderDTO.getDescription())));
        return "kitchenBanquetFoodOrderManage";
    }


    private String getDateToday(){
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        //Date date=new Date();
        //String today= dateFormat.format(date);
        //return today;
        return "s";
    }

    private String convertDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private boolean isDateValid(Date date){
        String dateS = convertDateToString(date);
        String today = getDateToday();

        String[] dateParts = dateS.split("/");
        int dateD = Integer.parseInt(dateParts[0]);
        int dateM = Integer.parseInt(dateParts[1]);
        int dateY = Integer.parseInt(dateParts[2]);


        String[] todayParts = today.split("/");
        int todayD = Integer.parseInt(todayParts[0]);
        int todayM = Integer.parseInt(todayParts[1]);
        int todayY = Integer.parseInt(todayParts[2]);

        if (dateY < todayY){
            return false;
        } else if (dateY >= todayY){
            if (dateY == todayY && dateM < todayM){
                return false;
            } else if (dateY == todayY && dateM >= todayM){
                if (dateY == todayY && dateM == todayM && dateD < todayD){
                    return false;
                }
            }
        }

        return true;
    }

}
