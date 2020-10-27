package lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO;

import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDetailDAO extends CrudRepository<RestaurantCounterOrderDetail,Integer> {

    Iterable<RestaurantCounterOrderDetail> findAllByRestaurantCounterOrderEquals(RestaurantCounterOrder item);
}
