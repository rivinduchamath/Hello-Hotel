package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.hotelManagement.dto.inventory.SupplierDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface InventoryBO extends SuperBO {
    List<ItemTypeDTO> findAll();

    List<InventoryDTO> findAllInventory();

    void saveInventoryItem(InventoryDTO inventoryDTO);

// Inventory Notice Load

    List<InventoryNoticeDTO> findDayAfterTomorrowNotice();

    List<InventoryNoticeDTO> findTodayInventoryNotice();

    List<InventoryNoticeDTO> findTomorrowInventoryNotice();

    void deleteInventoryNotice(int noticeId);

    InventoryDTO findInventory(int inventoryId);

    void updateInventory(InventoryDTO inventoryDTO1);

    List<InventoryNoticeDTO> findAllInventoryNotice();

    void deleteInventoryType(String id);

    ItemTypeDTO findTopByOrderByIdDesc();

    void saveInventoryType(ItemTypeDTO inventoryDTO);

    void saveSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> findAllSuppliers();

    SupplierDTO findTopByOrderBySupplierIdDesc();

    void deleteSupplier(int userId);

    InventoryNoticeDTO findTopByBarNoticeIdDesc();

    void saveOrderNotice(InventoryNoticeDTO noticeDTO);

    InventoryDTO findTopByOrderByOrderIdDesc();

    boolean findOne(int supplierId);
}
