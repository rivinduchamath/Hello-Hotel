package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.service.custom.ReservationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationBOImpl  implements ReservationBO {

    @Autowired
    CustomerDAO customerDAO;
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
        Iterable<Customer> li=customerDAO.findAll();
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
}
