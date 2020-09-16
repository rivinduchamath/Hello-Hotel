package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.TimeCheck;
import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.util.Date;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,Integer> {
    Iterable<OnlineTableReservation> findAllByStartTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeGreaterThanEqualAndStartTimeLessThanEqualAndDateEquals(Date startTime, Date endTime, Date date);
//    Iterable<OnlineTableReservation> findOnlineTableReservationsByDateEquals(Date date);

  //  Iterable<OnlineTableReservation> findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(Time startTime, Time endTime,Date date);

  //  Iterable<OnlineTableReservation> findOnlineTableReservationsByDateEquals(Date date);
}
