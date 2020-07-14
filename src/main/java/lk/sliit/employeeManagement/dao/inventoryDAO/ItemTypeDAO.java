package lk.sliit.employeeManagement.dao.inventoryDAO;

import lk.sliit.employeeManagement.entity.inventory.ItemType;
import org.springframework.data.repository.CrudRepository;

public interface ItemTypeDAO extends CrudRepository<ItemType,String> {
    ItemType findTopByOrderByIdDesc();
}
