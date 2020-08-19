package lk.sliit.hotelManagement.dao.beverageDAO;

import lk.sliit.hotelManagement.entity.barManage.BarBill;
import org.springframework.data.repository.CrudRepository;

public interface BarBillDAO extends CrudRepository<BarBill,String> {
}
