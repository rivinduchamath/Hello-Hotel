package lk.sliit.employeeManagement.dao.restaurantDAO.counterOrderDAO;

import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDAO extends CrudRepository<RestaurantCounterOrder,String> {
}
