package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.houseKeeping.RoomService;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
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
    public void saveRoomDetails(HotelRoomDTO hotelRoomDTO) {
        houseKeepingDAO.save(new HotelRoom(
                hotelRoomDTO.getRoomId2(),
                hotelRoomDTO.getRoomName(),
                hotelRoomDTO.getRoomType(),
                hotelRoomDTO.getDescription(),
                hotelRoomDTO.getStatus(),
                hotelRoomDTO.getHolder(),
                hotelRoomDTO.getPrice(),
                hotelRoomDTO.getDate()

        ));
    }

    @Override
    public HotelRoomDTO findHighestRoomId() {
        HotelRoom lastRoom = null;
        try {
            lastRoom = houseKeepingDAO.findTopByOrderByRoomIdDesc();
        } catch (Exception e){

        }

        return new HotelRoomDTO(lastRoom.getRoomId());
    }

    @Override
    public List<HotelRoomDTO> findRooms() {
        Iterable<HotelRoom> hotelRooms = houseKeepingDAO.findAll();
        List<HotelRoomDTO> hotelRoomDTOList = new ArrayList<>();

        for (HotelRoom room : hotelRooms) {
            hotelRoomDTOList.add(new HotelRoomDTO(
                    room.getRoomId(),
                    room.getRoomName(),
                    room.getRoomType(),
                    room.getDescription(),
                    room.getStatus(),
                    room.getHolder(),
                    room.getPrice(),
                    room.getDate()
            ));
        }
        return hotelRoomDTOList;
    }

    @Override
    public void deleteRoomDetails(String roomId) {
        houseKeepingDAO.delete(roomId);

    }

    @Override
    public HotelRoomDTO findRoomIdByID(String roomId) {
        HotelRoom hotelRoom = houseKeepingDAO.findOne(roomId);
        return new HotelRoomDTO(
                hotelRoom.getRoomId(),
                hotelRoom.getRoomName(),
                hotelRoom.getRoomType(),
                hotelRoom.getDescription(),
                hotelRoom.getStatus(),
                hotelRoom.getHolder(),
                hotelRoom.getPrice(),
                hotelRoom.getDate()
        );
    }
}
