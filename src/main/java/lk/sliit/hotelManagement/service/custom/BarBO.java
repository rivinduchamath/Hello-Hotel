package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface BarBO extends SuperBO {
    List<InventoryDTO> findAllBeverageItems(String s);

    List<BarOrderDTO> findAllBarOrders();

    void saveBarOrder(BarOrderDTO barOrderDTO);

    BarOrderDTO findTopByOrderByBarIdDesc();

    InventoryDTO findById(int itemCode);
}
