package lk.sliit.employeeManagement.dao.restaurantDAO.onlineTableReservationDAO;


import lk.sliit.employeeManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import org.springframework.data.repository.CrudRepository;

public interface OnlineTableReservationDAO extends CrudRepository<OnlineTableReservation,String> {
}
