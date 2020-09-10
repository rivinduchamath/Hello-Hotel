package lk.sliit.hotelManagement.dao.banquetDAO;

import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder,String> {

    BanquetOrder findTopByOrderByOrderIdDesc();

    Iterable<BanquetOrder> findBanquetOrdersByDateBetween(Date afterOneDays, Date afterThreeDays);

    @Modifying
    @Query(value = "Update BanquetOrder set orderState = ?1 where orderId=?2")
    void abc(String status,String orderId);
}
