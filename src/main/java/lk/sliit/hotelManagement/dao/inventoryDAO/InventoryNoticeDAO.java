package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface InventoryNoticeDAO extends CrudRepository<InventoryNotice,Integer> {

    Iterable<InventoryNotice> findAllByExpDateEquals(Date dayAfterTomorrow);

    InventoryNotice findTopByOrderByNoticeIdDesc();

    InventoryNotice findInventoryNoticeByInventoryAndExpDateEquals(Inventory noticeId, java.sql.Date date);

    Iterable<InventoryNotice> findAllByDateBetween(Date today, Date beforeWeek);
}
