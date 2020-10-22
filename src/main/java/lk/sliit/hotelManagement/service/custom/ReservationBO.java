package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    void savecustomer(CustomerDTO customerDTO);

    List<CustomerDTO> findAll();

    void deleteCustomer(int customerId);


    List<HotelRoomDTO> findAvilability(FindAvailabilityDTO findAvailabilityDTO);
}
