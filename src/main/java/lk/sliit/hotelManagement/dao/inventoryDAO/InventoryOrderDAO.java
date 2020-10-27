package lk.sliit.hotelManagement.dao.inventoryDAO;

import lk.sliit.hotelManagement.dto.inventory.InventoryOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.entity.inventory.InventoryOrder;
import org.springframework.data.repository.CrudRepository;

public interface InventoryOrderDAO extends CrudRepository<InventoryOrder,Integer> {

    InventoryOrder findTopByOrderByOrderIdDesc();


}
