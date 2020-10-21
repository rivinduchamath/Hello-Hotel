package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.ReservationDetailsDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservationDetails;
import lk.sliit.hotelManagement.service.custom.HouseKeepingBO;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationBOImpl implements ReservationBO {

    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    HouseKeepingDAO houseKeepingDAO;
    @Autowired
    ReservationDetailsDAO reservationDetailsDAO;

    @Override
    public void savecustomer(CustomerDTO customerDTO) {
        customerDAO.save(new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContactNumber()
        ));
    }

    @Override
    public List<CustomerDTO> findAll() {
        Iterable<Customer> li = customerDAO.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer c : li) {
            customerDTOS.add(new CustomerDTO(
                    c.getCustomerId(),
                    c.getEmail(),
                    c.getName(),
                    c.getAddress(),
                    c.getContactNumber()
            ));

        }
        return customerDTOS;
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerDAO.delete(customerId);
    }

    @Override
    public List<HotelRoomDTO> findAvilability(FindAvailabilityDTO findAvailabilityDTO) {
        Iterable<ReservationDetails> li = reservationDetailsDAO.find(findAvailabilityDTO.getCheckIn(), findAvailabilityDTO.getCheckOut());
        Iterable<HotelRoom> allData = houseKeepingDAO.findAll();
        List<HotelRoom> list = new ArrayList<>();
        List<HotelRoom> list2 = new ArrayList<>();

        for (HotelRoom d : allData) {
             for (ReservationDetails d2 : li) {
                if (d.getRoomId() != d2.getRoomId().getRoomId()) {
                    if (!list.contains(d.getRoomId())) {
                        list.add(d2.getRoomId());
                    }
                }
            }
        }
        for (HotelRoom d : allData) {
            if (!list.contains(d)) {
                list2.add(d);
            }
        }

        List<HotelRoomDTO> dtoList = new ArrayList<>();
        for (HotelRoom a : list2) {
            dtoList.add(new HotelRoomDTO(
                    a.getRoomId(),
                    a.getRoomName(),
                    a.getRoomType(),
                    a.getDescription(),
                    a.getStatus(),
                    a.getHolder(),
                    a.getPrice(),
                    a.getDate()

            ));
        }
        return dtoList;
    }
}
