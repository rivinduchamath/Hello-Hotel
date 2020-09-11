package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.InventoryOrder;
import org.springframework.data.repository.CrudRepository;

public interface InventoryOrderDAO extends CrudRepository<InventoryOrder,String> {

    InventoryOrder findTopByOrderByOrderIdDesc();
}
