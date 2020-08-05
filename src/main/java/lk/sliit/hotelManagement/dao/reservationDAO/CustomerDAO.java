package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,String> {
}
