package lk.sliit.hotelManagement.dao.kitchenDAO;


import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,String> {
    FoodItem findTopByOrderByItemIdDesc();
}