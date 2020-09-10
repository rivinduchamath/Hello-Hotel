package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryNoticeDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.ItemTypeDAO;
import lk.sliit.hotelManagement.dao.inventoryDAO.SupplierDAO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryDTO;
import lk.sliit.hotelManagement.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotelManagement.dto.inventory.ItemTypeDTO;
import lk.sliit.hotelManagement.dto.inventory.SupplierDTO;
import lk.sliit.hotelManagement.entity.TimeCheck;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.inventory.InventoryNotice;
import lk.sliit.hotelManagement.entity.inventory.ItemType;
import lk.sliit.hotelManagement.entity.inventory.Supplier;
import lk.sliit.hotelManagement.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InventoryBOImpl implements InventoryBO {

    @Autowired
    ItemTypeDAO itemTypeDAO;
    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    InventoryNoticeDAO inventoryNoticeDAO;
    @Autowired
    SupplierDAO supplierDAO;

    @Override
    public List<ItemTypeDTO> findAll() {
        Iterable<ItemType> all = itemTypeDAO.findAll();
        List<ItemTypeDTO> dtos = new ArrayList<>();
        for (ItemType a : all) {
            dtos.add(new ItemTypeDTO(
                    a.getId(),
                    a.getUserType(),
                    a.getSubmittedBy()
            ));
        }
        return dtos;
    }

    @Override
    public List<InventoryDTO> findAllInventory() {
        Iterable<Inventory> all = inventoryDAO.findAll();
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
    public void saveInventoryItem(InventoryDTO inventoryDTO) {
        inventoryDAO.save(new Inventory(
                inventoryDTO.getInventoryId(),
                inventoryDTO.getText(),
                inventoryDTO.getDescription(),
                inventoryDTO.getOrderQty(),
                inventoryDTO.getType(),
                inventoryDTO.getOrderLimit(),
                inventoryDTO.getGetPrice(),
                inventoryDTO.getSellingPrice(),
                inventoryDTO.getDate()
        ));
    }

    @Override
    public List<InventoryNoticeDTO> findDayAfterTomorrowNotice() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        java.util.Date dayAfterTomorrow = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateEquals(dayAfterTomorrow);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public List<InventoryNoticeDTO> findTodayInventoryNotice() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateEquals(today);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public List<InventoryNoticeDTO> findTomorrowInventoryNotice() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        java.util.Date tomorrow = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateEquals(tomorrow);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()


            ));
        }
        return dtos;
    }

    /*@Override
    public InventoryNoticeDTO findInventoryNotice(String noticeId) {
        InventoryNotice notice = inventoryNoticeDAO.findOne (noticeId);
        return new InventoryNoticeDTO (
                notice.getNoticeId(),
                notice.getDepartment(),
                notice.getOrderQty(),
                notice.getDate(),
                notice.getExpDate(),
                notice.getOrderHolder(),
                notice.isState(),
                notice.getInventory().getInventoryId()
        );
    }*/

   /* @Override
    public void updateNoticeState(InventoryNoticeDTO notice) {
        inventoryNoticeDAO.save(new InventoryNotice(
                notice.getNoticeId(),
                notice.getDepartment(),
                notice.getOrderQty(),
                notice.getDate(),
                notice.getExpDate(),
                notice.getOrderHolder(),
                notice.isState(),
                inventoryDAO.findOne ( notice.getInventory() )
        ));
    }*/

    @Override
    public void deleteInventoryNotice(String noticeId) {
        inventoryDAO.delete(noticeId);
    }


    @Override
    public InventoryDTO findInventory(String inventoryId) {
        Inventory notice = inventoryDAO.findOne(inventoryId);
        return new InventoryDTO(
                notice.getInventoryId(),
                notice.getText(),
                notice.getDescription(),
                notice.getOrderQty(),
                notice.getType(),
                notice.getOrderLimit(),
                notice.getGetPrice(),
                notice.getSellingPrice(),
                notice.getDate()
        );
    }

    @Override
    public void updateInventory(InventoryDTO inventoryDTO1) {
        inventoryDAO.save(new Inventory(
                inventoryDTO1.getInventoryId(),
                inventoryDTO1.getText(),
                inventoryDTO1.getDescription(),
                inventoryDTO1.getOrderQty(),
                inventoryDTO1.getType(),
                inventoryDTO1.getOrderLimit(),
                inventoryDTO1.getGetPrice(),
                inventoryDTO1.getSellingPrice(),
                inventoryDTO1.getDate()
        ));
    }

    @Override
    public List<InventoryNoticeDTO> findAllInventoryNotice() {
        Iterable<InventoryNotice> all = inventoryNoticeDAO.findAll();
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice a : all) {
            dtos.add(new InventoryNoticeDTO(
                    a.getNoticeId(),
                    a.getDepartment(),
                    a.getOrderQty(),
                    a.getDate(),
                    a.getExpDate(),
                    a.getOrderHolder(),
                    a.isState(),
                    a.getInventory().getInventoryId(),
                    a.getInventory().getText(),
                    a.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteInventoryType(String id) {
        itemTypeDAO.delete(id);
    }

    @Override
    public ItemTypeDTO findTopByOrderByIdDesc() {
        ItemType itemType = null;
        try {
            itemType = itemTypeDAO.findTopByOrderByIdDesc();
        } catch (Exception e) {
            // Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        return new ItemTypeDTO(
                itemType.getId()
        );
    }//End Get Total Emp

    @Override
    public void saveInventoryType(ItemTypeDTO inventoryDTO) {
        itemTypeDAO.save(new ItemType(
                inventoryDTO.getId(),
                inventoryDTO.getUserType(),
                inventoryDTO.getSubmittedBy()
        ));
    }

    @Override
    public void saveSupplier(SupplierDTO supplierDTO) {
        supplierDAO.save(new Supplier(
                supplierDTO.getId(),
                supplierDTO.getName(),
                supplierDTO.getAddress(),
                supplierDTO.getMobile(),
                supplierDTO.getEmail(),
                supplierDTO.getGender(),
                supplierDTO.getDate(),
                supplierDTO.getBirthday(),
                supplierDTO.getSubmittedBy()
        ));
    }

    @Override
    public List<SupplierDTO> findAllSuppliers() {
        Iterable<Supplier> all = supplierDAO.findAll();
        List<SupplierDTO> dtos = new ArrayList<>();
        for (Supplier a : all) {
            dtos.add(new SupplierDTO(
                    a.getId(),
                    a.getName(),
                    a.getAddress(),
                    a.getMobile(),
                    a.getEmail(),
                    a.getGender(),
                    a.getDate(),
                    a.getBirthday(),
                    a.getSubmittedBy()
            ));
        }
        return dtos;

    }

    @Override
    public SupplierDTO findTopByOrderBySupplierIdDesc() {
        Supplier supplier = null;
        try {
            supplier = supplierDAO.findTopByOrderByIdDesc();
        } catch (Exception e) {
            // Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        return new SupplierDTO(
                supplier.getId()
        );
    }//End Get Total

    @Override
    public void deleteSupplier(String userId) {
        supplierDAO.delete(userId);
    }

    @Override
    public InventoryNoticeDTO findTopByBarNoticeIdDesc() {
        InventoryNotice notice = null;
        try {
            notice = inventoryNoticeDAO.findTopByOrderByNoticeIdDesc();
        } catch (Exception e) {
        }
        return new InventoryNoticeDTO(
                notice.getNoticeId()
        );
    }//End Get Total

    @Override
    public void saveOrderNotice(InventoryNoticeDTO noticeDTO) {
        noticeDTO.setDepartment("Beverage");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        noticeDTO.setDate(date);
        noticeDTO.setState(false);
        try {
            InventoryNotice notice = inventoryNoticeDAO.findInventoryNoticeByInventoryAndExpDateEquals(
                    inventoryDAO.findOne(noticeDTO.getInventoryId()), noticeDTO.getExpDate());
            noticeDTO.setNoticeId(notice.getNoticeId());
            noticeDTO.setOrderQty((noticeDTO.getOrderQty() + notice.getOrderQty()));
        } catch (Exception e) {
        }

        inventoryNoticeDAO.save(new InventoryNotice(
                noticeDTO.getNoticeId(),
                noticeDTO.getDepartment(),
                noticeDTO.getOrderQty(),
                noticeDTO.getDate(),
                noticeDTO.getExpDate(),
                noticeDTO.getOrderHolder(),
                noticeDTO.isState(),
                inventoryDAO.findOne(noticeDTO.getInventoryId())

        ));
    }
}
