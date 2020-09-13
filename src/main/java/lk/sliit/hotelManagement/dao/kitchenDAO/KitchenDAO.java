package lk.sliit.hotelManagement.dao.kitchenDAO;


import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,Integer> {
    FoodItem findTopByOrderByItemIdDesc();

    Iterable<FoodItem> findAllByCategoryEquals(String restaurant);
}