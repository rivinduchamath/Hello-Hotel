package lk.sliit.hotelManagement.dao.restaurantDAO;

import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import org.springframework.data.repository.CrudRepository;

public interface OnlineCustomerDAO extends CrudRepository<OnlineCustomer,String> {
}
