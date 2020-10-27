package lk.sliit.hotelManagement.dao.kitchenDAO;

import lk.sliit.hotelManagement.entity.kitchen.KitchenFoodOrders;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface KitchenFoodOrderDAO extends CrudRepository<KitchenFoodOrders,Integer> {
    KitchenFoodOrders findTopByOrderByOrderIdDesc();

    Iterable<KitchenFoodOrders> findKitchenFoodOrdersByExpectedDateEqualsAndDescriptionStartsWith(Date date, String description);

    Iterable<KitchenFoodOrders> findTopByExpectedDateAndDescriptionEquals(Date date, String description);

    Iterable<KitchenFoodOrders> findAllByExpectedDateAndDescriptionStartsWith(Date date, String description);

    KitchenFoodOrders findKitchenFoodOrdersByExpectedDateAndFoodItemIdAndDescriptionEquals(java.sql.Date date, int id,String description);

    //KitchenFoodOrders findKitchenFoodOrdersByExpectedDateAndFoodItemIdAndDescriptionEquals(java.sql.Date date, int FoodItemId, String description);


}
