package lk.sliit.employeeManagement.dao;

import lk.sliit.employeeManagement.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryDAO extends CrudRepository<Inventory,String> {
}
