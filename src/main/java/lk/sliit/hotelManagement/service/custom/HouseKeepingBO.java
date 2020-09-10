package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface HouseKeepingBO extends SuperBO {

    void saveRoomDetails(HotelRoomDTO hotelRoomDTO);

    HotelRoomDTO findHighestRoomId();

    List<HotelRoomDTO> findRooms();


    void deleteRoomDetails(String roomId);

    HotelRoomDTO findRoomIdByID(String roomId);
}
