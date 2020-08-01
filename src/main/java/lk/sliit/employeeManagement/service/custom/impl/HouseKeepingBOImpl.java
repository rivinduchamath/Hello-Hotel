package lk.sliit.employeeManagement.service.custom.impl;

import lk.sliit.employeeManagement.dao.HouseKeepingDAO;
import lk.sliit.employeeManagement.dto.HouseKeepingDTO;
import lk.sliit.employeeManagement.entity.houseKeeping.HotelRoom;
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
//        Iterable<HotelRoom> all = houseKeepingDAO.findAll();
//        List<HouseKeepingDTO> dtos = new ArrayList<>();
//        for (HotelRoom a : all) {
//            dtos.add(new HouseKeepingDTO(
//                    a.getRoomId(),
//
//                    a.getDescription(),
//                    a.getPrice()
//            ));
//        }
     return null;
    }

    @Override
    public HouseKeepingDTO findTopByOrderByIdDesc() {
        HotelRoom houseKeeping = null;
        try {
            houseKeeping = houseKeepingDAO.findTopByOrderByRoomIdDesc ();
        }catch (Exception e){

        }
        return new HouseKeepingDTO(
                houseKeeping.getRoomId ()
        );
    }
}
