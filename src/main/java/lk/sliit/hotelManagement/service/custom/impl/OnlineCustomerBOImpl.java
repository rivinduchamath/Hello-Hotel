package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineCustomerBOImpl implements OnlineCustomerBO {

    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;

    @Override
    public OnlineCustomerDTO findHighestOnlineCustomerId() {
        OnlineCustomer lastCustomer = null;
        try {
            lastCustomer = onlineCustomerDAO.findTopByOrderByOnlineCustomerIdDesc();
            System.out.println(lastCustomer.getOnlineCustomerId()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        } catch (Exception e){

        }
        assert lastCustomer != null;
        return new OnlineCustomerDTO(
                lastCustomer.getOnlineCustomerId()
        );
    }

    @Override
    public void saveOnlineCustomer(OnlineCustomerDTO onlineCustomerDTO) {
        onlineCustomerDAO.save(new OnlineCustomer(
                onlineCustomerDTO.getOnlineCustomerId(),
                onlineCustomerDTO.getName(),
                onlineCustomerDTO.getUserName(),
                onlineCustomerDTO.getAddress(),
                onlineCustomerDTO.getEmail(),
                onlineCustomerDTO.getPassword(),
                onlineCustomerDTO.getContact()
        ));

    }

    @Override
    public OnlineCustomerDTO findByUserNameAndPassword(String userName, String password) {
        OnlineCustomer onlineCustomer = onlineCustomerDAO.findByUserNameAndPassword(userName,password);
        return new OnlineCustomerDTO (
                onlineCustomer.getOnlineCustomerId(),
                onlineCustomer.getUserName(),
                onlineCustomer.getPassword()
        );

    }

    @Override
    public OnlineCustomerDTO findOne(int onlineCustomerId) {
        OnlineCustomer onlineCustomer = onlineCustomerDAO.findOne(onlineCustomerId);
        return new OnlineCustomerDTO(
                onlineCustomer.getOnlineCustomerId(),
                onlineCustomer.getUserName(),
                onlineCustomer.getName()
        );

    }
}
