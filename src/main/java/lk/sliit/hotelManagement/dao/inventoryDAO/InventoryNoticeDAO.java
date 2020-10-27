package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface InventoryNoticeDAO extends CrudRepository<InventoryNotice,Integer> {



    InventoryNotice findTopByOrderByNoticeIdDesc();

    InventoryNotice findInventoryNoticeByInventoryAndExpDateEquals(Inventory noticeId, java.sql.Date date);

    Iterable<InventoryNotice> findAllByDateBetween(Date today, Date beforeWeek);

    Iterable<InventoryNotice> findAllByDateBetweenAndDepartmentEquals(Date beforeweek, Date todaya,String dep);

    InventoryNotice findInventoryNoticeByExpDateAndDepartmentAndInventoryAndStateEquals(java.sql.Date date, String department, Inventory id, boolean state);

    Iterable<InventoryNotice> findAllByExpDateAndStateEquals(Date tomorrow, boolean b);

}
