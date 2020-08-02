package lk.sliit.employeeManagement.dao.restaurantDAO.onlineOrderDAO;

import lk.sliit.employeeManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantOnlineOrderDetailsDAO extends CrudRepository<RestaurantOnlineOrderDetails,String> {
}
