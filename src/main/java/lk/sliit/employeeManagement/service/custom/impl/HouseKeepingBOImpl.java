package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.HouseKeepingDAO;
import lk.sliit.employeeManagement.dto.BarOrderDTO;
import lk.sliit.employeeManagement.dto.HouseKeepingDTO;
import lk.sliit.employeeManagement.dto.inventory.SupplierDTO;
import lk.sliit.employeeManagement.entity.HouseKeeping;
import lk.sliit.employeeManagement.entity.barManage.BarOrders;
import lk.sliit.employeeManagement.entity.inventory.Supplier;
import lk.sliit.employeeManagement.service.custom.HouseKeepingBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HouseKeepingBOImpl implements HouseKeepingBO {

    @Autowired
    HouseKeepingDAO houseKeepingDAO;

    @Override
    public List<HouseKeepingDTO> findAllRooms() {
        Iterable<HouseKeeping> all = houseKeepingDAO.findAll();
        List<HouseKeepingDTO> dtos = new ArrayList<>();
        for (HouseKeeping a : all) {
            dtos.add(new HouseKeepingDTO(
                    a.getRoomId(),
                    a.getName(),
                    a.getDescription(),
                    a.getPrice(),
                    a.getCategory(),
                    a.getTotalIncome(),
                    a.getSubmittedBy(),
                    a.getHrManagerId(),
                    a.getDate()
            ));
        }
        return dtos;
    }

    @Override
    public HouseKeepingDTO findTopByOrderByIdDesc() {
        HouseKeeping houseKeeping = null;
        try {
            houseKeeping = houseKeepingDAO.findTopByOrderByRoomIdDesc ();
        }catch (Exception e){

        }
        return new HouseKeepingDTO(
                houseKeeping.getRoomId ()
        );
    }
}
