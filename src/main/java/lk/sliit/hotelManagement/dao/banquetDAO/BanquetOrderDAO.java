package lk.sliit.hotelManagement.dao.banquetDAO;

import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.entity.banquet.BanquetBill;
import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder,Integer> {

    BanquetOrder findTopByOrderByOrderIdDesc();

    Iterable<BanquetOrder> findBanquetOrdersByDateBetween(Date afterOneDays, Date afterThreeDays);

    @Modifying
    @Query(value = "Update BanquetOrder set orderState = ?1 where orderId=?2")
    void updateBanStatus(String status,int orderId);

    Iterable<BanquetOrder> findBanquetOrdersByDate(Date todayDate);

    @Modifying
    @Query(value = "Update BanquetOrder set hallId = ?1 , noOfPlates = ?2 ,date=?3 ,menu=?4 where orderId=?5")
    void updateBanquetTable(String hallId, int noOfPlates, java.sql.Date date, Menu one, int orderId);

    Iterable<BanquetOrder> findAllByOrderStateEquals(String status);

    int countBanquetOrderByDateEquals(Date date);

    int countBanquetOrderByDateEqualsAndHallIdEquals(Date date, String hallNo);

    @Query(value = "select b.orderId from BanquetOrder b where b.date=:date and b.hallId=:hallNo ")
    int getOrderIdByDateEqualsAndHallIdEquals(@Param("date") Date date,@Param("hallNo") String hallNo);

    BanquetOrder findBanquetOrderByBanquetBillEquals(BanquetBill banquetBill);
}
