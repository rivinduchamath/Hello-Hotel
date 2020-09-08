package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;

import java.sql.Date;
import java.util.List;

public interface RestaurantBO {
    RestaurantCounterOrderDTO findTopByOrderByRestIdDesc();

    void saveRestaurantOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO);

    List<FoodItemDTO> findAllFoodItems(String restaurant);

    List<RestaurantTableDTO> findAllTable();

    List<RestaurantTableDTO> findAllTableDateEqual(Date date, String startTime, String endTime);
}
