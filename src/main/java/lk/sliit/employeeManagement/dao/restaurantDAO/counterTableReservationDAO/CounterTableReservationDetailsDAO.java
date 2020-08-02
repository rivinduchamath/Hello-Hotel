package lk.sliit.employeeManagement.dao.restaurantDAO.counterTableReservationDAO;

import lk.sliit.employeeManagement.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import org.springframework.data.repository.CrudRepository;

public interface CounterTableReservationDetailsDAO extends CrudRepository<CounterTableReservationDetails,String> {
}
