package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.ItemType;
import org.springframework.data.repository.CrudRepository;

public interface ItemTypeDAO extends CrudRepository<ItemType,String> {
    ItemType findTopByOrderByIdDesc();
}
