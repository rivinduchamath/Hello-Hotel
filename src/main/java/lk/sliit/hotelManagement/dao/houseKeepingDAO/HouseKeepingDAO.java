package lk.sliit.hotelManagement.dao.houseKeepingDAO;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import org.springframework.data.repository.CrudRepository;

public interface HouseKeepingDAO extends CrudRepository<HotelRoom,String> {
    HotelRoom findTopByOrderByRoomIdDesc();
}
