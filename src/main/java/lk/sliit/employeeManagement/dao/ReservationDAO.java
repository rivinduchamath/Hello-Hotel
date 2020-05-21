package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDAO extends CrudRepository<Reservation,String> {
}
