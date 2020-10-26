package lk.sliit.hotelManagement.dao.kitchenDAO;

import lk.sliit.hotelManagement.entity.kitchen.KitchenFoodOrders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface KitchenFoodOrderDAO extends CrudRepository<KitchenFoodOrders,Integer> {
    KitchenFoodOrders findTopByOrderByOrderIdDesc();

    Iterable<KitchenFoodOrders> findTopByExpectedDateEquals(Date date);

    KitchenFoodOrders findKitchenFoodOrdersByExpectedDateAndFoodItemIdEquals(int id, java.sql.Date date);


}
