package lk.sliit.employeeManagement.dao.restaurantDAO.onlineOrderDAO;

import lk.sliit.employeeManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantOnlineOrderDAO extends CrudRepository<RestaurantOnlineOrder,String> {
}
