package lk.sliit.hotelManagement.dao.houseKeepingDAO;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import org.springframework.data.repository.CrudRepository;

public interface HouseKeepingDAO extends CrudRepository<HotelRoom,Integer> {
    HotelRoom findTopByOrderByRoomIdDesc();


    Iterable<HotelRoom>  findAllByStatusEquals(String restaurant);

}
