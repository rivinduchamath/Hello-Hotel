package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.houseKeepingDAO.LaundryOrderDAO;
import lk.sliit.hotelManagement.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.houseKeeping.LaundryOrders;
import lk.sliit.hotelManagement.entity.houseKeeping.RoomService;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HouseKeepingBOImpl implements HouseKeepingBO {

    @Autowired
    HouseKeepingDAO houseKeepingDAO;
    @Autowired
    LaundryOrderDAO laundryOrderDAO;
    @Autowired
    CustomerDAO customerDAO;

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
        return getHotelRoomDTOS(hotelRooms);
    }

    @Override
    public void deleteRoomDetails(int roomId) {
        houseKeepingDAO.delete(roomId);

    }

    @Override
    public HotelRoomDTO findRoomIdByID(int roomId) {
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

    @Override
    public List<HotelRoomDTO> findDirtyRooms(String notCleaned) {
        Iterable<HotelRoom> hotelRooms = houseKeepingDAO.findAllByStatusEquals(notCleaned);
        return getHotelRoomDTOS(hotelRooms);
    }

    @Override
    public LaundryDTO findHighestId() {

        LaundryOrders laundryOrders = null;
        try {
            laundryOrders = laundryOrderDAO.findTopByOrderByLaundryIdDesc();
        } catch (Exception e){}

        return new LaundryDTO(laundryOrders.getLaundryId());
    }

    @Override
    public LaundryDTO findLaundryOrderById(int laundryId) {
        LaundryOrders laundryOrders = laundryOrderDAO.findOne(laundryId);
        return new LaundryDTO(
                laundryOrders.getLaundryId(),
                laundryOrders.getCustomerId().getCustomerId(),
                laundryOrders.getOrderHolder(),
                laundryOrders.getPieces(),
                laundryOrders.getExpectedDate(),
                laundryOrders.getDate()
        );
    }

    @Override
    public void saveLaundry(LaundryDTO laundryDTO) {
        Date a = new java.sql.Date(new java.util.Date().getTime());
        laundryDTO.setDate(a);
        laundryOrderDAO.save(new LaundryOrders(
                laundryDTO.getLaundryId(),
                laundryDTO.getOrderHolder(),
                laundryDTO.getPieces(),
                laundryDTO.getExpectedDate(),
                laundryDTO.getDate(),
                customerDAO.findOne(laundryDTO.getCustomerId())
        ));
    }

    @Override
    public List<CustomerDTO> findCustomers() {
        Iterable<Customer> all = customerDAO.findAllByStateEquals("In");

        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer customer: all) {
            dtos.add(new CustomerDTO(
                    customer.getCustomerId(),
                   customer.getEmail(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getContactNumber(),
                    customer.getState()
            ));
        }
        return dtos;

    }


    private List<HotelRoomDTO> getHotelRoomDTOS(Iterable<HotelRoom> hotelRooms) {
        List<HotelRoomDTO> hotelDirtyRoomDTOList = new ArrayList<>();

        for (HotelRoom room : hotelRooms) {
            hotelDirtyRoomDTOList.add(new HotelRoomDTO(
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
        return hotelDirtyRoomDTOList;
    }
}
