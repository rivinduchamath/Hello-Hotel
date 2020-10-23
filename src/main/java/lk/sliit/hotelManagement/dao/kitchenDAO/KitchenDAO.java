package lk.sliit.hotelManagement.dao.kitchenDAO;


import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,Integer> {
    FoodItem findTopByOrderByItemIdDesc();

    Iterable<FoodItem> findAllByCategoryEquals(String restaurant);

    @Query("from FoodItem where category!=?1")
    Iterable<FoodItem> findOnlyFoods(String category);

    @Query(value = "from FoodItem where category=?1")
    Iterable<FoodItem> findAllIngredients(String category);
}