package lk.sliit.hotelManagement.dao.banquetDAO;

import lk.sliit.hotelManagement.entity.banquet.BanquetBill;
import org.springframework.data.repository.CrudRepository;

public interface BanquetBillDAO extends CrudRepository<BanquetBill,String> {
}
