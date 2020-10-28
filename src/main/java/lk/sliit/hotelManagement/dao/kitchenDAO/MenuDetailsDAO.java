package lk.sliit.hotelManagement.dao.kitchenDAO;

import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuDetailsDAO extends CrudRepository<MenuDetails, Integer> {

    void deleteMenuDetailsByFoodItemEquals(FoodItem id);

    void deleteMenuDetailsByFoodItemAndMenuEquals(FoodItem foodItem, Menu menu);


    Iterable<MenuDetails> findMenuDetailsByMenu_MenuId(int menuId);
}
