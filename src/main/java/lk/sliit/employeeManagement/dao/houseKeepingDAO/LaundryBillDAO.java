package lk.sliit.employeeManagement.dao.houseKeepingDAO;


import lk.sliit.employeeManagement.entity.houseKeeping.LaundryBill;
import org.springframework.data.repository.CrudRepository;

public interface LaundryBillDAO extends CrudRepository<LaundryBill,String> {
}
