package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,Integer> {

    Iterable<OnlineTableReservation> findAllByStartTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeGreaterThanEqualAndStartTimeLessThanEqualAndDateEquals(Date startTime, Date endTime, Date date);



    @Query(value = "from OnlineTableReservation t where (t.startTime BETWEEN :endTime AND :startTimes) OR (t.endTime BETWEEN :endTime AND :startTimes) AND t.date = :date")
    Iterable<OnlineTableReservation> getAllBetweenDates(@Param("startTimes")Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);
}
