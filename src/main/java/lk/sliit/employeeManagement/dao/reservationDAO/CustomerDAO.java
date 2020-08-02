package lk.sliit.employeeManagement.dao.reservationDAO;

import lk.sliit.employeeManagement.entity.reservation.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,String> {
}
