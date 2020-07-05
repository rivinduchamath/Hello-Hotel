package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.employeeManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface InventoryBO extends SuperBO {
    List<ItemTypeDTO> findAll();
    List<InventoryDTO> findAllInventory();

    void saveInventoryItem(InventoryDTO inventoryDTO);

// Inventory Notice Load

    List<InventoryNoticeDTO> findDayAfterTomorrowNotice();

    List<InventoryNoticeDTO> findTodayInventoryNotice();

    List<InventoryNoticeDTO> findTomorrowInventoryNotice();

    InventoryNoticeDTO findInventoryNotice(String noticeId);

    void updateNoticeState(InventoryNoticeDTO noticeId);

    void deleteInventoryNotice(String noticeId);

    void saveInventory(InventoryNoticeDTO inventoryNoticeDTO);

    InventoryDTO findInventory(String inventoryId);

    void updateInventory(InventoryDTO inventoryDTO1);
}
