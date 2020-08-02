package lk.sliit.employeeManagement.dao.banquetDAO;

import lk.sliit.employeeManagement.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder,String> {
}
