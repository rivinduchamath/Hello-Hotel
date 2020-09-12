package lk.sliit.hotelManagement.dao.restaurantDAO;


import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantTableDAO extends CrudRepository<RestaurantTable,Integer> {

}
