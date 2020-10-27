package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.ReservationDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.ReservationDetailsDAO;
import lk.sliit.hotelManagement.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotelManagement.dto.reservation.ReservationDTO;
import lk.sliit.hotelManagement.dto.reservation.ReservationDetailDTO;

import lk.sliit.hotelManagement.entity.houseKeeping.HotelRoom;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.entity.reservation.Reservation;
import lk.sliit.hotelManagement.entity.reservation.ReservationDetails;

import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Calendar;
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
    @Autowired
    ReservationDAO reservationDAO;

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

    @Override
    public CustomerDTO findHighestOnlineCustomerId() {
        Customer orders = null;
        try {
            orders = customerDAO.findTopByOrderByCustomerIdDesc();
        } catch (Exception e) {

        }
        return new CustomerDTO(
                orders.getCustomerId()
        );
    }//End

    @Override
    public void saveOnlineCustomer(CustomerDTO customerDTO) {
        customerDAO.save(new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getAge(),
                "false",
                customerDTO.getPassword()
        ));
    }

    @Override
    public CustomerDTO findByUserNameAndPassword(String email, String password) {
        Customer customer = customerDAO.findByEmailAndPassword(email, password);
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getPassword()
        );
    }

    @Override
    public CustomerDTO findId(int customerId) {
        Customer customer = customerDAO.findOne(customerId);
        return new CustomerDTO(
                customer.getCustomerId(),
                customer.getName(),
                customer.getPassword()
        );
    }

    @Override
    public boolean findEmail(String email) {
        email = email.trim();
        Customer customer = null;
        try {
            customer = customerDAO.findCustomerByEmailEquals(email);

        } catch (Exception e) {
            return true;
        }
        if (customer == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ReservationDTO findTopByReservationId() {
        Reservation reservation = null;
        try {
            reservation = reservationDAO.findTopByOrderByReservationIdDesc();
        } catch (Exception e) {

        }
        return new ReservationDTO(
                reservation.getReservationId()
        );
    }//End

    @Override
    public void saveReservaation(ReservationDTO reservationDTO) {
        java.util.List<ReservationDetailDTO> list = new ArrayList<>();
        String arr = reservationDTO.getDetails();
        String yo[] = arr.split(" ");
        int count = 0;
        ReservationDetailDTO itm = new ReservationDetailDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new ReservationDetailDTO();
                itm.setRoomId(Integer.parseInt(str));
                list.add(itm);
                count = 0;
            }
        }

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        Date a = new java.sql.Date(new java.util.Date().getTime());
        reservationDTO.setDate(a);

        reservationDAO.save(new Reservation(

                reservationDTO.getReservationId(),
                "Online",
                reservationDTO.getDate(),
                3,
                customerDAO.findOne(reservationDTO.getCustomer())
        ));

        for (ReservationDetailDTO orderDetail : list) {
            reservationDetailsDAO.save(new ReservationDetails(

                    reservationDTO.getReservationId(),
                    orderDetail.getRoomId(),
                    reservationDTO.getCheckIn(),
                    reservationDTO.getCheckOut()
            ));

        }
    }

    @Override
    public CustomerDTO findCustomerByEmail(String email) {
        email = email.trim();
        Customer customer = null;
        try {
            customer = customerDAO.findCustomerByEmailEquals(email);

        } catch (Exception e) {
            return null;
        }

        return new CustomerDTO(
          customer.getCustomerId()
        );
    }

    @Override
    public void saveReservaationCounter(ReservationDTO reservationDTO) {
        java.util.List<ReservationDetailDTO> list = new ArrayList<>();
        String arr = reservationDTO.getDetails();
        String yo[] = arr.split(" ");
        int count = 0;
        ReservationDetailDTO itm = new ReservationDetailDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new ReservationDetailDTO();
                itm.setRoomId(Integer.parseInt(str));
                list.add(itm);
                count = 0;
            }
        }

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        Date a = new java.sql.Date(new java.util.Date().getTime());
        reservationDTO.setDate(a);

        reservationDAO.save(new Reservation(

                reservationDTO.getReservationId(),
                "OTC",
                reservationDTO.getDate(),
                3,
                customerDAO.findOne(reservationDTO.getCustomer())
        ));

        for (ReservationDetailDTO orderDetail : list) {
            reservationDetailsDAO.save(new ReservationDetails(

                    reservationDTO.getReservationId(),
                    orderDetail.getRoomId(),
                    reservationDTO.getCheckIn(),
                    reservationDTO.getCheckOut()
            ));

        }
    }
}



