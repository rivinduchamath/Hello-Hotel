package lk.sliit.employeeManagement.dao.reservationDAO;

import lk.sliit.employeeManagement.entity.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDAO extends CrudRepository<Reservation,String> {
}
