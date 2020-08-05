package lk.sliit.hotelManagement.dao.restaurantDAO;

import lk.sliit.hotelManagement.entity.restaurant.RestaurantBill;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantBillDAO extends CrudRepository<RestaurantBill,String> {
}
