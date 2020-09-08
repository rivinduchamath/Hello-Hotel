package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.houseKeeping.RoomService;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseKeepingBOImpl implements HouseKeepingBO {

    @Autowired
    HouseKeepingDAO houseKeepingDAO;

    @Override
    public void saveRoomDetails(HotelRoomDTO hotelRoomDTO) {
        houseKeepingDAO.save(new HotelRoom(
                hotelRoomDTO.getRoomId(),
                hotelRoomDTO.getRoomName(),
                hotelRoomDTO.getRoomType(),
                hotelRoomDTO.getDescription(),
                hotelRoomDTO.getStatus(),
                hotelRoomDTO.getDate()

        ));
    }
}
