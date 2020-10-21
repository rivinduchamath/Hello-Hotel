package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface ReservationDetailsDAO extends CrudRepository<ReservationDetails,Integer> {


    @Query(value = "from ReservationDetails t where (t.arrivalDate between :checkOut and :checkIn) or (t.departureDate between :checkOut and :checkIn) or (t.departureDate >= :checkIn and t.arrivalDate <= :checkOut)")
    Iterable<ReservationDetails> find(@Param("checkIn") java.util.Date checkIn, @Param("checkOut") java.util.Date checkOut);


}
