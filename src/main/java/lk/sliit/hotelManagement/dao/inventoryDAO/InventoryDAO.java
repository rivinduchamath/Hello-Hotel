package lk.sliit.hotelManagement.dao.inventoryDAO;


import lk.sliit.hotelManagement.entity.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryDAO extends CrudRepository<Inventory,Integer> {
    Iterable<Inventory> findAllByTypeEquals(String name);

    Inventory findTopByOrderByInventoryIdDesc();


}
