package lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO;

import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface RestaurantCounterOrderDAO extends CrudRepository<RestaurantCounterOrder,Integer> {


    RestaurantCounterOrder findTopByOrderByOrderIdDesc();

    Iterable<RestaurantCounterOrder> findAllByOrderIdEquals(int orderId);

    Iterable<RestaurantCounterOrder> findAllByDateEquals(Date date);
}
