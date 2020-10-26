package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,Integer> {
    Customer findTopByOrderByCustomerIdDesc();

    Iterable<Customer> findAllByStateEquals(String state);

    Customer findByEmailAndPassword(String email, String password);

    Customer findCustomerByEmailEquals(String email);
}
