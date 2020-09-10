package lk.sliit.hotelManagement.dao;

import lk.sliit.hotelManagement.entity.TimeCheck;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Time;

public interface TimeDAO extends CrudRepository<TimeCheck, String> {
    //Iterable<OnlineTableReservation> findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(Time startTime, Time endTime, Date date);

   // Iterable<OnlineTableReservation> findOnlineTableReservationsByDateEquals(Date date);


    //Iterable<TimeCheck> findTimeChecksByTimeSettANBetweenAndDateEquals();

  //  Iterable<TimeCheck> findAlla();
}
