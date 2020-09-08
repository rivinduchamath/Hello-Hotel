package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.kitchen.MenuDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Time;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,String> {
//    Iterable<OnlineTableReservation> findOnlineTableReservationsByDateEquals(Date date);

    Iterable<OnlineTableReservation> findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(Date startTime, Date endTime,Date date);
}
