package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.service.SuperBO;

public interface HouseKeepingBO extends SuperBO {

    void saveRoomDetails(HotelRoomDTO hotelRoomDTO);
}
