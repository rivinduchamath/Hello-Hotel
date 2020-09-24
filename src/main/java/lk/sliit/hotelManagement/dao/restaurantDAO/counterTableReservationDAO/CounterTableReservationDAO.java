package lk.sliit.hotelManagement.dao.restaurantDAO.counterTableReservationDAO;

import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CounterTableReservationDAO extends CrudRepository<CounterTableReservation,Integer> {


    @Query(value = "from CounterTableReservation t where (t.startTime between :endTime and :startTimes) or (t.endTime between :endTime and :startTimes) or (t.endTime >= :startTimes and t.startTime <= :endTime) and t.date = :date")
    Iterable<CounterTableReservation> getAllBetweenDates(@Param("startTimes") Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);

    Iterable<CounterTableReservation> findCounterTableReservationByDateEquals(Date date);
}
