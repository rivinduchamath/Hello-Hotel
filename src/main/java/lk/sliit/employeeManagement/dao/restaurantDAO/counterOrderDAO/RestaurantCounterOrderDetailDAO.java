package lk.sliit.employeeManagement.dao.restaurantDAO.counterOrderDAO;

import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDetailDAO extends CrudRepository<RestaurantCounterOrderDetail,String> {
}
