package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,String> {
}
