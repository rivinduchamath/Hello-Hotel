package lk.sliit.hotelManagement.dao.restaurantDAO;

import lk.sliit.hotelManagement.entity.restaurant.OnlineLocation;
import org.springframework.data.repository.CrudRepository;

public interface OnlineCustomerLocations extends CrudRepository<OnlineLocation,Integer> {
    OnlineLocation findTopByOrderByLocationIdDesc();
}
