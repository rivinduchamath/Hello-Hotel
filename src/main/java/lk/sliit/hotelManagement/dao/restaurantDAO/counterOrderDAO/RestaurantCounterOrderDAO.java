package lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO;

import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDAO extends CrudRepository<RestaurantCounterOrder,String> {
}
