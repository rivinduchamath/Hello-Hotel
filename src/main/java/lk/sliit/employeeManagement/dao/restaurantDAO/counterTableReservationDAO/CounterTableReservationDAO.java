package lk.sliit.employeeManagement.dao.restaurantDAO.counterTableReservationDAO;

import lk.sliit.employeeManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import org.springframework.data.repository.CrudRepository;

public interface CounterTableReservationDAO extends CrudRepository<CounterTableReservation,String> {
}
