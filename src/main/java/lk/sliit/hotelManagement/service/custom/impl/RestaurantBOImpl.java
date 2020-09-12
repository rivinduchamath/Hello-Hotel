package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.RestaurantTableDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO.OnlineTableReservationDAO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.OnlineCustomerDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDetailsDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.entity.barManage.BarOrders;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class RestaurantBOImpl implements RestaurantBO {
    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    KitchenDAO foodItem;
    @Autowired
    RestaurantTableDAO restaurantTableDAO;
    @Autowired
    OnlineTableReservationDAO onlineTableReservationDAO;
    @Autowired
    RestaurantCounterOrderDAO restaurantCounterOrderDAO;
    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetail;
    @Autowired
    RestaurantOnlineOrderDetailsDAO onlineOrderDetailsDAO;
    @Autowired
    RestaurantOnlineOrderDAO onlineOrderDAO;

    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;
    @Override
    public RestaurantCounterOrderDTO findTopByOrderByRestIdDesc() {

        RestaurantCounterOrder orders = null;
        try {
            orders = restaurantCounterOrderDAO.findTopByOrderByOrderIdDesc();
        } catch (Exception e) {

        }
        return new RestaurantCounterOrderDTO(
                orders.getOrderId()
        );
    }//End


    @Transactional
    @Override
    public void saveRestaurantOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO) {
        java.util.List<RestaurantCounterOrderDetailDTO> list = new ArrayList<>();
        String arr = restaurantCounterOrderDTO.getDataValue();
        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantCounterOrderDetailDTO itm = new RestaurantCounterOrderDetailDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new RestaurantCounterOrderDetailDTO();
                itm.setFoodItem(Integer.parseInt(str));
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        restaurantCounterOrderDTO.setDate(today);
        restaurantCounterOrderDAO.save(new RestaurantCounterOrder(
                restaurantCounterOrderDTO.getOrderId(),
                restaurantCounterOrderDTO.getOrderState(),
                restaurantCounterOrderDTO.getQuantity(),
                restaurantCounterOrderDTO.getDate(),
                restaurantCounterOrderDTO.getCustomerId(),
                restaurantCounterOrderDTO.getOrderHolder()));

        for (RestaurantCounterOrderDetailDTO orderDetail : list) {
            restaurantCounterOrderDetail.save(new RestaurantCounterOrderDetail(
                    restaurantCounterOrderDTO.getOrderId(),
                    orderDetail.getFoodItem(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitePrice()));

        }
    }

    @Override
    public List<FoodItemDTO> findAllFoodItems(String restaurant) {
        Iterable<FoodItem> all = foodItem.findAllByCategoryEquals(restaurant);
        List<FoodItemDTO> dtos = new ArrayList<>();
        for (FoodItem a : all) {
            dtos.add(new FoodItemDTO(
                    a.getItemId(),
                    a.getName(),
                    a.getUnitePrice(),
                    a.getCategory(),
                    a.getSrc()
            ));
        }
        return dtos;
    }

    @Override
    public List<RestaurantTableDTO> findAllTable() {
        Iterable<RestaurantTable> all = restaurantTableDAO.findAll();
        List<RestaurantTableDTO> dtos = new ArrayList<>();
        for (RestaurantTable a : all) {
            dtos.add(new RestaurantTableDTO(
                    a.getTableId(),
                    a.getType(),
                    a.getUnitPrice()
            ));
        }
        return dtos;
    }


    @Override
    public RestaurantOnlineOrderDTO findHighestOnlineOrderId() {
        RestaurantOnlineOrder orders = null;
        try {
            orders = onlineOrderDAO.findTopByOrderByOrderIdDesc();
        } catch (Exception e) {

        }
        return new RestaurantOnlineOrderDTO(
                orders.getOrderId()
        );
    }//End


    @Override
    public void saveOnlineOrder(RestaurantOnlineOrderDTO onlineOrderDTO) {
        java.util.List<RestaurantOnlineOrderDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();
        System.out.println("arrrrrrrrrrrrrrrrrrrrrrrrrr"+arr);
        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantOnlineOrderDetailsDTO itm = new RestaurantOnlineOrderDetailsDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new RestaurantOnlineOrderDetailsDTO();
                itm.setFoodItem(Integer.parseInt(str));
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        onlineOrderDTO.setDate(today);
        onlineOrderDAO.save(new RestaurantOnlineOrder(
                onlineOrderDTO.getOrderId(),
                onlineOrderDTO.getOrderState(),
                onlineOrderDTO.getDate(),
                onlineCustomerDAO.findOne(onlineOrderDTO.getCustomer())));

        for (RestaurantOnlineOrderDetailsDTO orderDetail : list) {
            onlineOrderDetailsDAO.save(new RestaurantOnlineOrderDetails(
                    onlineOrderDTO.getOrderId(),
                    orderDetail.getFoodItem(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitePrice()));

        }
    }

    @Override
    public List<RestaurantTableDTO> findAllTableDateEqual(java.util.Date reservedDate) {
        return null;
    }

    public List<RestaurantTableDTO> findAllTableDateEqual(Date date, String startTime,
                                                          String endTime) {

/////////////////////////////////////////////////////////////////////////////
//        Iterable<OnlineTableReservation> all = onlineTableReservationDAO.findOnlineTableReservationsByDateEquals(date);
        Date s = Date.valueOf(startTime);
        Date s1 = Date.valueOf(endTime);
        //  Iterable<OnlineTableReservation> all1 = onlineTableReservationDAO.findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(s, s1, date);
        List<OnlineTableReservationDTO> dtos = new ArrayList<>();
        // for (OnlineTableReservation a : all1) {
      /*      dtos.add(new OnlineTableReservationDTO(
                    a.getOnlineTableReservationId(),
                    a.getType(),
                    a.getUnitPrice()
            ));*/
        // }


        return null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    // @Override
    public List<RestaurantTableDTO> findAllTableDateEqual(OnlineTableReservationDTO onlineTable) {

        Time s = (Time.valueOf(onlineTable.getStartTime()+":00"));
        Time s1 = (Time.valueOf(onlineTable.getEndTime()+":00"));
        // Iterable<OnlineTableReservation> all1 = onlineTableReservationDAO.findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(onlineTable.getDate());
        // for (OnlineTableReservation d : all1) {
        //     System.out.println("ssssssssssssssssssssssssssssssssssssssss"+d);
        // }

        List<OnlineTableReservationDTO> dtos = new ArrayList<>();

        return null;
    }

//    Online table


    //Onlene Order


    //Counter Table


    //Counter Order
}
