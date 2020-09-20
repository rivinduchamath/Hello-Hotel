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
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDetailsDTO;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservationDetails;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<RestaurantTableDTO> getAviTables(java.util.Date date, java.util.Date startTime, java.util.Date endTime) {
      /*  Iterable<OnlineTableReservation> all = onlineTableReservationDAO.findAllByStartTimeBetweenAndDateEquals(startTime, endTime, date);
        Iterable<OnlineTableReservation> all2 = onlineTableReservationDAO.findAllByEndTimeBetweenAndDateEquals(startTime, endTime, date);
        Iterable<OnlineTableReservation> all3 = onlineTableReservationDAO.findAllByEndTimeGreaterThanEqualAndStartTimeLessThanEqualAndDateEquals(endTime, startTime, date);
      */
        Iterable<OnlineTableReservation> all4 = onlineTableReservationDAO.getAllBetweenDates(endTime, startTime,date);
        Iterable<RestaurantTable> allTable = restaurantTableDAO.findAll();
        Iterable<OnlineTableReservationDetails> al4;
        List<RestaurantTable> list = new ArrayList<>();


        for (RestaurantTable d: allTable) {
            for (OnlineTableReservation a1 : all4) {
                al4 = a1.getOrderDetails();
                for (OnlineTableReservationDetails s : al4) {
                        if(d.getTableId() != s.getTableId().getTableId()){
                               if(!list.contains(s.getTableId())) {
                                   list.add(s.getTableId());
                               }
                        }
                    }
                }
            }


        for (RestaurantTable  s: allTable) {
            if(!list.contains(s.getTableId())){

            }
        }

        return null;
    }

    @Override
    public RestaurantTableDTO findHighestTableId() {
        RestaurantTable lastItem = null;
        try {
            lastItem = restaurantTableDAO.findTopByOrderByTableIdDesc();
        } catch (Exception e){

        }
        return new RestaurantTableDTO(lastItem.getTableId());
    }

    @Override
    public void saveTable(RestaurantTableDTO restaurantTableDTO) {
        restaurantTableDAO.save(new RestaurantTable
                        (restaurantTableDTO.getTableId(),
                        restaurantTableDTO.getType(),
                        restaurantTableDTO.getUnitPrice()));
    }

    @Override
    public List<RestaurantTableDTO> findTables() {
        Iterable<RestaurantTable> tables = restaurantTableDAO.findAll();
        List<RestaurantTableDTO> tableDTOList = new ArrayList<>();

        for (RestaurantTable item: tables) {
            tableDTOList.add(new RestaurantTableDTO(item.getTableId(),
                    item.getType(),
                    item.getUnitPrice()));
        }
        return tableDTOList;
    }

    @Override
    public void deleteTable(int tableId) {
        restaurantTableDAO.delete(tableId);
    }

    @Override
    public RestaurantTableDTO findTableById(int tableId) {
        RestaurantTable table = restaurantTableDAO.findOne(tableId);
        return new RestaurantTableDTO(
                table.getTableId(),
                table.getType(),
                table.getUnitPrice()
        );
    }


    //Online table


    //Online Order


    //Counter Table


    //Counter Order
}
