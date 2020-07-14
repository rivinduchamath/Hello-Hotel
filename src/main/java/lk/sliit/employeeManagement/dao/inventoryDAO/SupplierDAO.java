package lk.sliit.employeeManagement.dao.inventoryDAO;

import lk.sliit.employeeManagement.entity.inventory.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierDAO extends CrudRepository<Supplier,String> {
    Supplier findTopByOrderByIdDesc();
}
