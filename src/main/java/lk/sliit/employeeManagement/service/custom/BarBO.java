package lk.sliit.employeeManagement.service.custom;

import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.service.SuperBO;

import java.util.List;

public interface BarBO extends SuperBO {
    List<InventoryDTO> findAllBeverageItems(String s);
}
