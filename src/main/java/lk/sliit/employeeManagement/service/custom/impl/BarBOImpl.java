package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.BarOrdersDAO;
import lk.sliit.employeeManagement.dao.BarOrdersDetailsDAO;
import lk.sliit.employeeManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.employeeManagement.dto.BarOrderDTO;
import lk.sliit.employeeManagement.dto.BarOrderDetailDTO;
import lk.sliit.employeeManagement.dto.inventory.InventoryDTO;
import lk.sliit.employeeManagement.entity.barManage.BarOrderDetails;
import lk.sliit.employeeManagement.entity.barManage.BarOrders;
import lk.sliit.employeeManagement.entity.inventory.Inventory;
import lk.sliit.employeeManagement.service.custom.BarBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BarBOImpl implements BarBO {

    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    BarOrdersDAO barOrdersDAO;
    @Autowired
    BarOrdersDetailsDAO barOrdersDetailsDAO;

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

    @Override
    public List<BarOrderDTO> findAllBarOrders() {
        Iterable<BarOrders> all = barOrdersDAO.findAll();
        List<BarOrderDTO> dtos = new ArrayList<>();
        for (BarOrders a : all) {
            dtos.add(new BarOrderDTO(
                    a.getOrderId(),
                    a.getCustomerId(),
                    a.getUser()
            ));
        }
        return dtos;
    }

    @Override
    public void saveBarOrder(BarOrderDTO barOrderDTO) {

        List<BarOrderDetailDTO> s = new ArrayList<>();
        BarOrderDetailDTO sa = new BarOrderDetailDTO();
        sa.setItemCode("I001");
        sa.setTotalPrice(21);
        sa.setItemName("ddddddddddd");
        sa.setQty(221);
        sa.setItemPrice(22333);
        s.add(0,sa);
        System.out.println(barOrderDTO.getCustomerId());
        System.out.println(barOrderDTO.getId());
        System.out.println(barOrderDTO.getUser());
        System.out.println(barOrderDTO.getOrderData());
        System.out.println(barOrderDTO.getDate());



      /*  for (String s: list) {
            String[] sourceAry1 =  s.split("  ");
            for(String value : sourceAry1) {
                list2.add (value );
            }
        }*/
      /*  for (String s: list2) {
            System.out.println(s);
        }*/
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today =  cal.getTime();
        barOrderDTO.setDate(today);
        barOrdersDAO.save(new BarOrders (
                barOrderDTO.getId (),
                barOrderDTO.getDate(),
                barOrderDTO.getCustomerId (),
                barOrderDTO.getUser () ));

        for (BarOrderDetailDTO orderDetail :s ) {
            barOrdersDetailsDAO.save(new BarOrderDetails( barOrderDTO.getId (), orderDetail.getItemCode(),
                    orderDetail.getItemPrice(), orderDetail.getQty()));
            Inventory inventory = inventoryDAO.findOne(orderDetail.getItemCode());
            inventory.setOrderQty(inventory.getOrderQty() - orderDetail.getQty());
            inventoryDAO.save(inventory);
        }




    }


}
