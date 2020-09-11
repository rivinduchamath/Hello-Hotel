package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDetailsDAO extends CrudRepository<ReservationDetails,Integer> {
}
