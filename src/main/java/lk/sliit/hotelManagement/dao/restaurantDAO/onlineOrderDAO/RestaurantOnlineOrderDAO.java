package lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO;

import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantOnlineOrderDAO extends CrudRepository<RestaurantOnlineOrder,String> {
    RestaurantOnlineOrder findTopByOrderByOrderIdDesc();
}
