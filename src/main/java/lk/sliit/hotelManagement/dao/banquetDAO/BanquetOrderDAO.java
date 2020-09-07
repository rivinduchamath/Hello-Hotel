package lk.sliit.hotelManagement.dao.banquetDAO;

import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder,String> {

    BanquetOrder findTopByOrderByOrderIdDesc();

    Iterable<BanquetOrder> findBanquetOrdersByDateBetween(Date todaydate, Date afterOneMonth);
}
