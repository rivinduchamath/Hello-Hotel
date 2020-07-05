package lk.sliit.employeeManagement.dao.inventoryDAO;

import lk.sliit.employeeManagement.entity.inventory.InventoryNotice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface InventoryNoticeDAO extends CrudRepository<InventoryNotice,String> {

    Iterable<InventoryNotice> findAllByExpDateEquals(Date dayAfterTomorrow);
}
