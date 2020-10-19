package lk.sliit.hotelManagement.dao.houseKeepingDAO;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.houseKeeping.LaundryOrders;
import org.springframework.data.repository.CrudRepository;

public interface LaundryOrderDAO extends CrudRepository<LaundryOrders,Integer> {

    LaundryOrders findTopByOrderByLaundryIdDesc();
}
