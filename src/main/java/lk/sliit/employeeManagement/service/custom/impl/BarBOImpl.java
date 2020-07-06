package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.entity.inventory.Inventory;
import lk.sliit.employeeManagement.service.custom.BarBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BarBOImpl implements BarBO {

    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public List<InventoryDTO> findAllBeverageItems(String s) {
        Iterable<Inventory> all = inventoryDAO.findAllByTypeEquals(s);
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory a : all) {
            dtos.add(new InventoryDTO(
                    a.getInventoryId(),
                    a.getText(),
                    a.getDescription(),
                    a.getOrderQty(),
                    a.getType(),
                    a.getOrderLimit(),
                    a.getGetPrice(),
                    a.getSellingPrice(),
                    a.getDate()
            ));
        }
        return dtos;
    }
}
