package lk.sliit.hotelManagement.dao.kitchenDAO;

import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuDetailsDAO extends CrudRepository<MenuDetails, Integer> {


    @Modifying
    @Query(value = "delete from MenuDetails where foodItem =?1 and menu =?2")
    void deleteMenuDetailsByID(int foodItemId, int menuItemId);



    Iterable<MenuDetails> findMenuDetailsByMenu_MenuId(int menuId);
}
