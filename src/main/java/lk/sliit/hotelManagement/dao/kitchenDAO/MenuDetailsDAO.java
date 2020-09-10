package lk.sliit.hotelManagement.dao.kitchenDAO;

import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import org.springframework.data.repository.CrudRepository;

public interface MenuDetailsDAO extends CrudRepository<MenuDetails, FoodItem> {

    Iterable<MenuDetails> findMenuDetailsByMenu_MenuId(String menuId);
}
