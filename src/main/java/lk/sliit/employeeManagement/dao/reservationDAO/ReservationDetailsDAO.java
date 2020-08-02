package lk.sliit.employeeManagement.dao.reservationDAO;

import lk.sliit.employeeManagement.entity.reservation.ReservationDetails;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDetailsDAO extends CrudRepository<ReservationDetails,String> {
}
