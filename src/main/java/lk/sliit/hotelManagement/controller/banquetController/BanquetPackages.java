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

        ArrayList<FoodItemDTO> foodlist1= new ArrayList<>();
        ArrayList<FoodItemDTO> foodlist2= new ArrayList<>();
        ArrayList<FoodItemDTO> foodlist3= new ArrayList<>();
        ArrayList<FoodItemDTO> foodlist4= new ArrayList<>();
        ArrayList<String> card1category1= new ArrayList<>();
        ArrayList<String> card1category2= new ArrayList<>();
        ArrayList<String> card1category3= new ArrayList<>();
        ArrayList<String> card2category1= new ArrayList<>();
        ArrayList<String> card2category2= new ArrayList<>();
        ArrayList<String> card2category3= new ArrayList<>();
        ArrayList<String> card3category1= new ArrayList<>();
        ArrayList<String> card3category2= new ArrayList<>();
        ArrayList<String> card3category3= new ArrayList<>();
        ArrayList<String> card4category1= new ArrayList<>();
        ArrayList<String> card4category2= new ArrayList<>();
        ArrayList<String> card4category3= new ArrayList<>();
        List<MenuDetailsDTO> list1 = kitchenBO.findFoodItemsDetails(1);
        for(MenuDetailsDTO i:list1){
            foodlist1.add(kitchenBO.findFoodItemById(i.getFoodItemID()));
        }
        for(FoodItemDTO a :foodlist1){
            if (a.getItemCategory().equals("Desserts"))
                card1category1.add(a.getItemName());
            if (a.getItemCategory().equals("Rice & Noodles"))
                card1category2.add(a.getItemName());
            if (a.getItemCategory().equals("Mains"))
                card1category3.add(a.getItemName());
        }

        List<MenuDetailsDTO> list2 = kitchenBO.findFoodItemsDetails(2);
        for(MenuDetailsDTO i:list2){
            foodlist2.add(kitchenBO.findFoodItemById(i.getFoodItemID()));
        }
        for(FoodItemDTO a :foodlist2){
            if (a.getItemCategory().equals("Desserts"))
                card2category1.add(a.getItemName());
            if (a.getItemCategory().equals("Rice & Noodles"))
                card2category2.add(a.getItemName());
            if (a.getItemCategory().equals("Mains"))
                card2category3.add(a.getItemName());
        }

        List<MenuDetailsDTO> list3 = kitchenBO.findFoodItemsDetails(3);
        for(MenuDetailsDTO i:list3){
            foodlist3.add(kitchenBO.findFoodItemById(i.getFoodItemID()));
        }
        for(FoodItemDTO a :foodlist3){
            if (a.getItemCategory().equals("Desserts"))
                card3category1.add(a.getItemName());
            if (a.getItemCategory().equals("Rice & Noodles"))
                card3category2.add(a.getItemName());
            if (a.getItemCategory().equals("Mains"))
                card3category3.add(a.getItemName());
        }

        List<MenuDetailsDTO> list4 = kitchenBO.findFoodItemsDetails(4);
        for(MenuDetailsDTO i:list4){
            foodlist4.add(kitchenBO.findFoodItemById(i.getFoodItemID()));
        }
        for(FoodItemDTO a :foodlist4){
            if (a.getItemCategory().equals("Desserts"))
                card4category1.add(a.getItemName());
            if (a.getItemCategory().equals("Rice & Noodles"))
                card4category2.add(a.getItemName());
            if (a.getItemCategory().equals("Mains"))
                card4category3.add(a.getItemName());
        }

        mv.addObject("card1category1",card1category1);
        mv.addObject("card1category2",card1category2);
        mv.addObject("card1category3",card1category3);
        mv.addObject("card2category1",card2category1);
        mv.addObject("card2category2",card2category2);
        mv.addObject("card2category3",card2category3);
        mv.addObject("card3category1",card3category1);
        mv.addObject("card3category2",card3category2);
        mv.addObject("card3category3",card3category3);
        mv.addObject("card4category1",card4category1);
        mv.addObject("card4category2",card4category2);
        mv.addObject("card4category3",card4category3);


        MenuDTO menu1 = kitchenBO.findMenuItemById(1);
        MenuDTO menu2 = kitchenBO.findMenuItemById(2);
        MenuDTO menu3 = kitchenBO.findMenuItemById(3);
        MenuDTO menu4 = kitchenBO.findMenuItemById(4);
        mv.addObject("menu1",menu1);
        mv.addObject("menu2",menu2);
        mv.addObject("menu3",menu3);
        mv.addObject("menu4",menu4);

        return mv;
    }
}
