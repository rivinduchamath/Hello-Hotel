package lk.sliit.employeeManagement.dao.restaurantDAO;


import lk.sliit.employeeManagement.entity.restaurant.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantTableDAO extends CrudRepository<RestaurantTable,String> {
}
