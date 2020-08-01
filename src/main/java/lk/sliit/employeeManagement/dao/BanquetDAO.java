package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

public interface BanquetDAO extends CrudRepository<BanquetOrder,String> {
}
