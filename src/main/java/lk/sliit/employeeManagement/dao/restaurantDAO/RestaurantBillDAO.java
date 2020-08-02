package lk.sliit.employeeManagement.dao.restaurantDAO;

import lk.sliit.employeeManagement.entity.restaurant.RestaurantBill;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantBillDAO extends CrudRepository<RestaurantBill,String> {
}
