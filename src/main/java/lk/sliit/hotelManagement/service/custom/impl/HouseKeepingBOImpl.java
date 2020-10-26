package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.houseKeepingDAO.LaundryOrderDAO;
import lk.sliit.hotelManagement.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.ReservationDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotelManagement.dto.houseKeeping.RoomServiceDTO;
import lk.sliit.hotelManagement.dto.inventory.GetDateHouseKeepingDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.manager.EmployeeDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.ReservationDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.houseKeeping.LaundryOrders;
import lk.sliit.hotelManagement.entity.houseKeeping.RoomService;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.manager.Employee;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.entity.reservation.Reservation;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;
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
    ReservationDAO reservationDAO;
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
        } catch (Exception e){}
        return new HotelRoomDTO(lastRoom.getRoomId());
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
                "Accept",
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

    @Override
    public List<LaundryDTO> findLaundryData() {
        Iterable<LaundryOrders> all = laundryOrderDAO.findAllByStateEquals("Accept");

        List<LaundryDTO> dtos = new ArrayList<>();
        for (LaundryOrders customer: all) {
            dtos.add(new LaundryDTO(
                    customer.getLaundryId(),
                    customer.getCustomerId().getCustomerId(),
                    customer.getCustomerId().getName(),
                    customer.getOrderHolder(),
                    customer.getPieces(),
                    customer.getExpectedDate(),
                    customer.getDate(),
                    customer.getState()
            ));
        }
        return dtos;

    }

    @Override
    public void deleteLaundryOrder(int id) {
        laundryOrderDAO.delete(id);
    }

    @Override
    public List<LaundryDTO> findProcessingLaundryData() {
        Iterable<LaundryOrders> all = laundryOrderDAO.findAllByStateEquals("Processing");

        List<LaundryDTO> dtos = new ArrayList<>();
        for (LaundryOrders customer: all) {
            dtos.add(new LaundryDTO(
                    customer.getLaundryId(),
                    customer.getCustomerId().getCustomerId(),
                    customer.getCustomerId().getName(),
                    customer.getOrderHolder(),
                    customer.getPieces(),
                    customer.getExpectedDate(),
                    customer.getDate(),
                    customer.getState()
            ));
        }
        return dtos;

    }

    @Override //Change State To Processing
    public void changeState(int id) {
        LaundryOrders all = laundryOrderDAO.findOne(id);
        all.setState("Processing");
        laundryOrderDAO.save(all);
    }

    @Override
    public List<ReservationDTO> findBill(GetDateHouseKeepingDTO getDto) {
        List<GetDateHouseKeepingDTO> hotelDirtyRoomDTOList = new ArrayList<>();
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        Iterable<Reservation> hotelRooms = reservationDAO.findAllByDateBetween(getDto.getDateIn(),getDto.getDateOut());

        for (Reservation reservation : hotelRooms) {
            reservationDTOS.add(new ReservationDTO(
                 reservation.getReservationId(),
                    reservation.getCustomer().getCustomerId(),
                    reservation.getReservationDetails(),
                    reservation.getDate(),
                    reservation.getNoOfRooms()
            ));
        }
        return reservationDTOS;
    }


    @Override//Find All Rooms
    public List<HotelRoomDTO> findRooms() {
        Iterable<HotelRoom> hotelRooms = houseKeepingDAO.findAll();
        return getHotelRoomDTOS(hotelRooms);
    }


    @Override //Find Dirty Rooms
    public List<HotelRoomDTO> findDirtyRooms(String notCleaned) {
        Iterable<HotelRoom> hotelRooms = houseKeepingDAO.findAllByStatusEquals(notCleaned);
        return getHotelRoomDTOS(hotelRooms);
    }

    //Convert Entity object to DTO Object (Remove BoilerPlate Code)
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

    @Override
    public void deleteRoomDetails(int roomId) {
        houseKeepingDAO.delete(roomId);
    }
}
