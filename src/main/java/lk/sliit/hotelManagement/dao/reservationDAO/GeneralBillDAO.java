package lk.sliit.hotelManagement.dao.reservationDAO;

import lk.sliit.hotelManagement.entity.reservation.GeneralBill;
import org.springframework.data.repository.CrudRepository;

public interface GeneralBillDAO extends CrudRepository<GeneralBill,String> {
}
