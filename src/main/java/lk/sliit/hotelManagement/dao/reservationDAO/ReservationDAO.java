package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDAO extends CrudRepository<Reservation,Integer> {
}
