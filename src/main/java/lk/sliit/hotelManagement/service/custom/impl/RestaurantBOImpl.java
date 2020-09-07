package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.RestaurantTableDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    RestaurantCounterOrderDAO restaurantCounterOrderDAO;
    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetail;
    @Override
    public RestaurantCounterOrderDTO findTopByOrderByRestIdDesc() {
        return null;
    }

    @Override
    public void saveRestaurantOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO) {
        java.util.List<RestaurantCounterOrderDetailDTO> list = new ArrayList<RestaurantCounterOrderDetailDTO>();
        String arr = restaurantCounterOrderDTO.getDataValue();
        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantCounterOrderDetailDTO itm = new RestaurantCounterOrderDetailDTO();
        for(String str:yo) {
            if(count == 0 ) {
                itm = new RestaurantCounterOrderDetailDTO();
                itm.setFoodItem(str);
                count ++;

            }else if(count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count ++;

            }else if(count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today =  cal.getTime();
        restaurantCounterOrderDTO.setDate(today);
        restaurantCounterOrderDAO.save(new RestaurantCounterOrder(
                restaurantCounterOrderDTO.getOrderId (),
                restaurantCounterOrderDTO.getOrderState(),
                restaurantCounterOrderDTO.getQuantity(),
                restaurantCounterOrderDTO.getDate(),
                restaurantCounterOrderDTO.getCustomerId (),
                restaurantCounterOrderDTO.getOrderHolder () ));

        for (RestaurantCounterOrderDetailDTO orderDetail :list ) {
            restaurantCounterOrderDetail.save(new RestaurantCounterOrderDetail(
                    restaurantCounterOrderDTO.getOrderId (),
                    orderDetail.getFoodItem(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitePrice()

            ));
           /* Inventory inventory = inventoryDAO.findOne(orderDetail.getFoodItem());
            inventory.setOrderQty(inventory.getOrderQty() - orderDetail.getQuantity());
            inventoryDAO.save(inventory);*/
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

//    Online table


    //Onlene Order


    //Counter Table


    //Counter Order
}
