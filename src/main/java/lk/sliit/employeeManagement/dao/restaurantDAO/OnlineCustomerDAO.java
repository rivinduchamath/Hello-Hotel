package lk.sliit.employeeManagement.dao.restaurantDAO;

import lk.sliit.employeeManagement.entity.restaurant.OnlineCustomer;
import org.springframework.data.repository.CrudRepository;

public interface OnlineCustomerDAO extends CrudRepository<OnlineCustomer,String> {
}
