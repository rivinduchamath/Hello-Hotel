package lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,Integer> {

    Iterable<OnlineTableReservation> findAllByStartTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeBetweenAndDateEquals(Date startTime, Date endTime, Date date);

    Iterable<OnlineTableReservation> findAllByEndTimeGreaterThanEqualAndStartTimeLessThanEqualAndDateEquals(Date startTime, Date endTime, Date date);

}
