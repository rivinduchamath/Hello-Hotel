package lk.sliit.hotelManagement.dao.restaurantDAO.counterTableReservationDAO;

import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import org.springframework.data.repository.CrudRepository;

public interface CounterTableReservationDetailsDAO extends CrudRepository<CounterTableReservationDetails,Integer> {
}
