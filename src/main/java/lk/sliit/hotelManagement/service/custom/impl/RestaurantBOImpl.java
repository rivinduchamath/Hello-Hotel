package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.RestaurantTableDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO.OnlineTableReservationDAO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.entity.barManage.BarOrders;
import lk.sliit.hotelManagement.entity.inventory.Inventory;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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
                itm.setFoodItem(str);
                System.out.println(str + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                System.out.println(str + "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                System.out.println(itm + "cccceeeeeeeeeeeeeeeeeeeeccc");
                list.add(itm);
                count = 0;
            }
        }
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + restaurantCounterOrderDTO.getOrderId());
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
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");


        for (RestaurantCounterOrderDetailDTO orderDetail : list) {
            System.out.println(restaurantCounterOrderDTO.getOrderId() + "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" + orderDetail.getFoodItem());
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
    public List<RestaurantTableDTO> findAllTableDateEqual(Date date, String startTime,
                                                          String endTime) {


//        Iterable<OnlineTableReservation> all = onlineTableReservationDAO.findOnlineTableReservationsByDateEquals(date);
        System.out.println("22222222222222222222222222222222222222222222222222222" + date + "" + startTime + "" + endTime);
        Date s = Date.valueOf(startTime);
        Date s1 = Date.valueOf(endTime);
        Iterable<OnlineTableReservation> all1 = onlineTableReservationDAO.findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(s, s1, date);
        List<OnlineTableReservationDTO> dtos = new ArrayList<>();
        for (OnlineTableReservation a : all1) {
      /*      dtos.add(new OnlineTableReservationDTO(
                    a.getOnlineTableReservationId(),
                    a.getType(),
                    a.getUnitPrice()
            ));*/


            System.out.println("22222222222222222222222222222222222222222222222222222" + a.getOnlineTableReservationId());
        }


        return null;
    }

//    Online table


    //Onlene Order


    //Counter Table


    //Counter Order
}
