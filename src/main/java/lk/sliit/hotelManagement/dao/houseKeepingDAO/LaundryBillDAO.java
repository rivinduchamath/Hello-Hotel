package lk.sliit.hotelManagement.dao.houseKeepingDAO;


import lk.sliit.hotelManagement.entity.houseKeeping.LaundryBill;
import org.springframework.data.repository.CrudRepository;

public interface LaundryBillDAO extends CrudRepository<LaundryBill,Integer> {
}
