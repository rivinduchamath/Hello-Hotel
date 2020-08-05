package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierDAO extends CrudRepository<Supplier,String> {
    Supplier findTopByOrderByIdDesc();
}
