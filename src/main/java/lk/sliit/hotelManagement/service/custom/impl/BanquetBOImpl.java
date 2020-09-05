package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.banquetDAO.BanquetBillDAO;
import lk.sliit.hotelManagement.dao.banquetDAO.BanquetOrderDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.MenuDAO;
import lk.sliit.hotelManagement.dao.reservationDAO.CustomerDAO;
import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetBillDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.entity.banquet.BanquetBill;
import lk.sliit.hotelManagement.entity.banquet.BanquetOrder;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.service.custom.BanquetBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class BanquetBOImpl implements BanquetBO {

    @Autowired
    BanquetOrderDAO banquetOrderDAO;
    @Autowired
    BanquetBillDAO banquetBillDAO;
    @Autowired
    MenuDAO menuDAO;
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public void saveBanquet(BanquetAddDTO banquetAddDTO) {
        banquetAddDTO.setCustomerId("3");
        customerDAO.save(new Customer(
                banquetAddDTO.getCustomerId(),
                banquetAddDTO.getEmail(),
                banquetAddDTO.getName(),
                banquetAddDTO.getAddress(),
                banquetAddDTO.getContactNumber()
        ));
        banquetAddDTO.setBanquetBillId("5");
        double zero=0.0;
        banquetAddDTO.setTotal(zero);
        banquetAddDTO.setFoodPrice(zero);
        banquetAddDTO.setOtherPrice(zero);
        banquetBillDAO.save(new BanquetBill(
                banquetAddDTO.getBanquetBillId(),
                banquetAddDTO.getTotal(),
                banquetAddDTO.getFoodPrice(),
                banquetAddDTO.getOtherPrice(),
                banquetAddDTO.getAdvanceFee()
        ));
        String status ="processing";
        banquetAddDTO.setOrderState(status);
        banquetOrderDAO.save(new BanquetOrder(
                banquetAddDTO.getOrderId(),
                banquetAddDTO.getHallId(),
                banquetAddDTO.getOrderState(),
                banquetAddDTO.getNoOfPlates(),
                banquetAddDTO.getDate(),
                banquetAddDTO.getSubmittedBy(),
                customerDAO.findOne(banquetAddDTO.getCustomerId()),
                menuDAO.findOne(banquetAddDTO.getMenuId()),
                banquetBillDAO.findOne(banquetAddDTO.getBanquetBillId())
        ));

    }

    @Override
    public BanquetOrderDTO findTopBanquetId() {

        BanquetOrder banquetOrder = banquetOrderDAO.findTopByOrderByOrderIdDesc();
        return new BanquetOrderDTO(
                banquetOrder.getOrderId()
        );
    }

    @Override
    public CustomerDTO findTopCustomerId() {

        Customer customer = customerDAO.findTopByOrderByCustomerIdDesc();
        return new CustomerDTO(
                customer.getCustomerId()
        );
    }

    @Override
    public BanquetBillDTO findTopBanquetBillId() {
        BanquetBill banquetBill =banquetBillDAO.findTopByOrderByBillIdDesc();
        return new BanquetBillDTO(
                banquetBill.getBillId()
        );
    }

    @Override
    @Transactional(readOnly = false)
    public List<CustomerDTO> findAllCustomers() {
        Iterable<Customer> all = customerDAO.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        for ( Customer a: all){
            dtos.add(new CustomerDTO(
                    a.getCustomerId(),
                    a.getEmail(),
                    a.getName(),
                    a.getAddress(),
                    a.getContactNumber()
            ));
        }
        return dtos;
    }

    /*
    @Override
    public List<BanquetOrderDTO> findAllBanquet() {
        Iterable<BanquetOrder> all = banquetOrderDAO.findAll();
        List<BanquetOrderDTO> dtos = new ArrayList<>();
        for ( BanquetOrder a: all){
            dtos.add(new BanquetOrderDTO(
                    a.getOrderId(),
                    a.getCustomer(),
                    a.getCustomer(),
                    a.getDate(),
                    a.getHallId(),
                    a.getNoOfPlates(),
                    a.getMenu(),
                    a.getBanquetBill()
            ));
        }
        return dtos;
    }*/
}
