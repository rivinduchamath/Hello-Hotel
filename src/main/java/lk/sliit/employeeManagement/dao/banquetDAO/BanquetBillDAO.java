package lk.sliit.employeeManagement.dao.banquetDAO;

import lk.sliit.employeeManagement.entity.banquet.BanquetBill;
import org.springframework.data.repository.CrudRepository;

public interface BanquetBillDAO extends CrudRepository<BanquetBill,String> {
}
