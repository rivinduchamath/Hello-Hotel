package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.service.SuperBO;

public interface HumanResourceBO extends SuperBO {
    void updateRoomHR(HotelRoomDTO hotelRoomDTO);
}
