package lk.sliit.hotelManagement.dao.restaurantDAO.counterTableReservationDAO;

import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import org.springframework.data.repository.CrudRepository;

public interface CounterTableReservationDAO extends CrudRepository<CounterTableReservation,Integer> {
}
