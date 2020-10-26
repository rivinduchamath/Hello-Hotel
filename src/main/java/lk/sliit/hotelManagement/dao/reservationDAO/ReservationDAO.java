package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ReservationDAO extends CrudRepository<Reservation,Integer> {
    Reservation findTopByOrderByReservationIdDesc();

    Iterable<Reservation> findAllByDateBetween(Date dateIn, Date dateOut);
}
