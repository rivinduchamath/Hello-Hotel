package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerLocations;
import lk.sliit.hotelManagement.dto.kitchen.MenuDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerLocationsDTO;
import lk.sliit.hotelManagement.entity.kitchen.Menu;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.entity.reservation.Customer;
import lk.sliit.hotelManagement.entity.restaurant.OnlineCustomer;
import lk.sliit.hotelManagement.entity.restaurant.OnlineLocation;
import lk.sliit.hotelManagement.service.custom.OnlineCustomerBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OnlineCustomerBOImpl implements OnlineCustomerBO {

    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;
    @Autowired
    OnlineCustomerLocations onlineCustomerLocations;

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

    @Override
    public List<OnlineCustomerLocationsDTO> findDeliveryLocation() {
        Iterable<OnlineLocation> li= onlineCustomerLocations.findAll();
        List<OnlineCustomerLocationsDTO> locationsDTOS = new ArrayList<>();
        for (OnlineLocation c : li) {
            locationsDTOS.add(new OnlineCustomerLocationsDTO(
                    c.getLocationId(),
                    c.getLocation()
            ));
        }
        return locationsDTOS;
    }

    @Override
    public void deleteLocation(int locationId) {
       try {
           onlineCustomerLocations.delete(locationId);
       }catch (EmptyResultDataAccessException e){}
    }

    @Override
    public OnlineCustomerLocationsDTO findHighestOnlineLocationId() {
        OnlineLocation location = null;
        try {
            location = onlineCustomerLocations.findTopByOrderByLocationIdDesc();
        } catch (Exception e){}
        assert location != null;
        return new OnlineCustomerLocationsDTO(
                location.getLocationId()
        );
    }

    @Override
    public OnlineCustomerLocationsDTO findOnlineLocationbyId(int locationId) {
        OnlineLocation onlineLocation = onlineCustomerLocations.findOne(locationId);
        return new OnlineCustomerLocationsDTO(
                onlineLocation.getLocationId(),
                onlineLocation.getLocation()
        );
    }

    @Override
    public void saveLocation(OnlineCustomerLocationsDTO onlineCustomerLocationsDTO) {
        onlineCustomerLocations.save(new OnlineLocation(
                onlineCustomerLocationsDTO.getLocationId(),
                onlineCustomerLocationsDTO.getLocationNames()
        ));

    }
}
