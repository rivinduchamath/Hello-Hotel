package lk.sliit.employeeManagement.dao.inventoryDAO;


import lk.sliit.employeeManagement.entity.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryDAO extends CrudRepository<Inventory,String> {
    Iterable<Inventory> findAllByTypeEquals(String name);
}
