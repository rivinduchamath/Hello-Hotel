package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerLocationsDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;

import java.util.List;

public interface OnlineCustomerBO {
    OnlineCustomerDTO findHighestOnlineCustomerId();

    void saveOnlineCustomer(OnlineCustomerDTO onlineCustomerDTO);

    OnlineCustomerDTO findByUserNameAndPassword(String userName, String password);

    OnlineCustomerDTO findOne(int getOnlineCustomerId);

    List<OnlineCustomerLocationsDTO> findDeliveryLocation();

    void deleteLocation(int locationId); 

    OnlineCustomerLocationsDTO findHighestOnlineLocationId();

    OnlineCustomerLocationsDTO findOnlineLocationbyId(int locationId);

    void saveLocation(OnlineCustomerLocationsDTO onlineCustomerLocationsDTO);
}
