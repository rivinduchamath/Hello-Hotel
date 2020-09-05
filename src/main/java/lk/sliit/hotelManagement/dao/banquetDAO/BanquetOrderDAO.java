package lk.sliit.hotelManagement.dao.banquetDAO;

import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder,String> {

    BanquetOrder findTopByOrderByOrderIdDesc();
}
