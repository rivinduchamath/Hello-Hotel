package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,Integer> {


    @Query(value = "from OnlineTableReservation t where (t.startTime between :endTime and :startTimes) or (t.endTime between :endTime and :startTimes) or (t.endTime >= :startTimes and t.startTime <= :endTime) and t.reservedDate = :date")
    Iterable<OnlineTableReservation> getAllBetweenDates(@Param("startTimes")Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);

    OnlineTableReservation findTopByOrderByOnlineTableReservationIdDesc();

    Iterable<OnlineTableReservation> findOnlineTableReservationByReservedDateEquals(Date date);



    Iterable<OnlineTableReservation> findAllByReservedDateBetween(Date todaydate, Date dt);
}
