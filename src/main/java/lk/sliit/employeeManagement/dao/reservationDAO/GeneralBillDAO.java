package lk.sliit.employeeManagement.dao.reservationDAO;

import lk.sliit.employeeManagement.entity.reservation.GeneralBill;
import org.springframework.data.repository.CrudRepository;

public interface GeneralBillDAO extends CrudRepository<GeneralBill,String> {
}
