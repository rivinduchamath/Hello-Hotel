package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.beverageDAO.BarOrdersDAO;
import lk.sliit.hotelManagement.dao.beverageDAO.BarOrdersDetailsDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDetailDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.entity.barManage.BarOrderDetails;
import lk.sliit.hotelManagement.entity.barManage.BarOrders;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.service.custom.BarBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
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

    @Transactional
    @Override
    public void saveBarOrder(BarOrderDTO barOrderDTO) {

        java.util.List<BarOrderDetailDTO> list = new ArrayList<BarOrderDetailDTO>();
        String arr = barOrderDTO.getOrderData();
        String yo[] = arr.split(" ");
        int count = 0;
        BarOrderDetailDTO itm = new BarOrderDetailDTO();
        for(String str:yo) {
            if(count == 0 ) {
                itm = new BarOrderDetailDTO();
                itm.setItemCode(Integer.parseInt(str));
                count ++;

            }else if(count == 1) {
                itm.setItemPrice(Double.parseDouble(str));
                count ++;

            }else if(count == 2) {
                itm.setQty(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today =  cal.getTime();
        barOrderDTO.setDate(today);
        barOrdersDAO.save(new BarOrders (
                barOrderDTO.getId (),
                barOrderDTO.getDate(),
                barOrderDTO.getCustomerId (),
                barOrderDTO.getUser ()));

        for (BarOrderDetailDTO orderDetail :list ) {
            barOrdersDetailsDAO.save(new BarOrderDetails(
                    barOrderDTO.getId (), orderDetail.getItemCode(),
                    orderDetail.getItemPrice(), orderDetail.getQty()));
            Inventory inventory = inventoryDAO.findOne(orderDetail.getItemCode());
            inventory.setOrderQty(inventory.getOrderQty() - orderDetail.getQty());
            inventoryDAO.save(inventory);
        }
    }

    @Override
    public BarOrderDTO findTopByOrderByBarIdDesc() {
        BarOrders orders = null;
        try {
            orders = barOrdersDAO.findTopByOrderByOrderIdDesc ();
        }catch (Exception e){

        }
        return new BarOrderDTO(
                orders.getOrderId ()
        );
    }//End


}
