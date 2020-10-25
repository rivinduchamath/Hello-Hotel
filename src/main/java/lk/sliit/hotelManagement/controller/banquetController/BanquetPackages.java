package lk.sliit.hotelManagement.controller.banquetController;

import lk.sliit.hotelManagement.controller.SuperController;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotelManagement.service.custom.IndexLoginBO;
import lk.sliit.hotelManagement.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BanquetPackages {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/displayBanquetPackages")
    public ModelAndView loginPage(Model model){
        ModelAndView mv = new ModelAndView("banquetPackages");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<FoodItemDTO> foodlist= new ArrayList<>();
        List<MenuDetailsDTO> list = kitchenBO.findFoodItemsDetails(1);
        for(MenuDetailsDTO i:list){
            foodlist.add(kitchenBO.findFoodItemById(i.getFoodItemID()));
        }


        mv.addObject("card1",foodlist);

        return mv;
    }
}
