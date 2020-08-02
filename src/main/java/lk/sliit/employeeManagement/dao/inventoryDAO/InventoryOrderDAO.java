package lk.sliit.employeeManagement.dao.inventoryDAO;

import lk.sliit.employeeManagement.entity.inventory.InventoryOrder;
import org.springframework.data.repository.CrudRepository;

public interface InventoryOrderDAO extends CrudRepository<InventoryOrder,String> {

}
