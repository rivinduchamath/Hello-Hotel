package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotelManagement.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.RestaurantTableDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterTableReservationDAO.CounterTableReservationDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.counterTableReservationDAO.CounterTableReservationDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO.OnlineTableReservationDAO;
import lk.sliit.hotelManagement.dao.restaurantDAO.onlineTableReservationDAO.OnlineTableReservationDetailsDAO;
import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable.CounterTableReservationDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable.CounterTableReservationDetailsDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDetailsDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;
import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDetailsDTO;
import lk.sliit.hotelManagement.entity.kitchen.FoodItem;
import lk.sliit.hotelManagement.entity.restaurant.RestaurantTable;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotelManagement.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservation;
import lk.sliit.hotelManagement.entity.restaurant.onlineTableReservation.OnlineTableReservationDetails;
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
    OnlineTableReservationDetailsDAO onlineTableReservationDetailsDAO;
    @Autowired
    OnlineTableReservationDAO onlineTableReservationDAO;
    @Autowired
    CounterTableReservationDAO counterTableReservationDAO;
    @Autowired
    CounterTableReservationDetailsDAO counterTableReservationDetailsDAO;
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

        Iterable<OnlineTableReservation> all4 = onlineTableReservationDAO.getAllBetweenDates(endTime, startTime, date);
        Iterable<CounterTableReservation> all5 = counterTableReservationDAO.getAllBetweenDates(endTime, startTime, date);
        Iterable<RestaurantTable> allTable = restaurantTableDAO.findAll();
        Iterable<OnlineTableReservationDetails> al4;
        Iterable<CounterTableReservationDetails> al5;
        List<RestaurantTable> list = new ArrayList<>();
        List<RestaurantTable> list22 = new ArrayList<>();
        List<RestaurantTable> list2 = new ArrayList<>();


        for (RestaurantTable d : allTable) {
            for (OnlineTableReservation d2 : all4) {
                al4 = d2.getOrderDetails();
                for (OnlineTableReservationDetails d3 : al4) {
                    if (d.getTableId() != d3.getTableId().getTableId()) {
                        if (!list.contains(d3.getTableId())) {
                            list.add(d3.getTableId());
                        }
                    }
                }
            }
        }
        for (RestaurantTable d : allTable) {
            for (CounterTableReservation d2 : all5) {
                al5 = d2.getOrderDetails();
                for (CounterTableReservationDetails d3 : al5) {
                    if (d.getTableId() != d3.getTableId().getTableId()) {
                        if (!list22.contains(d3.getTableId())) {
                            list22.add(d3.getTableId());
                        }
                    }
                }
            }
        }

        for (RestaurantTable b : allTable) {
            if (!list.contains(b) && !list22.contains(b)) {
                list2.add(b);
            }
        }
        List<RestaurantTableDTO> dtoList = new ArrayList<>();
        for (RestaurantTable a : list2) {
            dtoList.add(new RestaurantTableDTO(
                    a.getTableId(),
                    a.getType(),
                    a.getUnitPrice()
            ));
        }
        return dtoList;
    }

    @Override
    public List<CounterTableReservationDTO> getBookedTables() {
        java.util.Date date = new java.util.Date();
        List<CounterTableReservationDTO> list = new ArrayList<>();
        List<OnlineTableReservationDetails> list4 = new ArrayList<>();
        List<CounterTableReservationDetails> list5 = new ArrayList<>();
        Iterable<OnlineTableReservation> onlineTableReservations = null;
        Iterable<CounterTableReservation> counterTableReservations = null;
        try {

            onlineTableReservations = onlineTableReservationDAO.findOnlineTableReservationByReservedDateEquals(date);
            counterTableReservations = counterTableReservationDAO.findCounterTableReservationByDateEquals(date);
        } catch (NullPointerException e) {
        }

        for (OnlineTableReservation d2 : onlineTableReservations) {
            list4 = d2.getOrderDetails();
            for (OnlineTableReservationDetails a : list4) {

                list.add(new CounterTableReservationDTO(
                        d2.getOnlineTableReservationId(),
                        d2.getStartTime(),
                        d2.getEndTime(),
                        a.getTableId().getType()
                ));
            }
        }
        for (CounterTableReservation d2 : counterTableReservations) {
            list5 = d2.getOrderDetails();
            for (CounterTableReservationDetails a : list5) {

                list.add(new CounterTableReservationDTO(
                        d2.getCounterTableReserveId(),
                        d2.getStartTime(),
                        d2.getEndTime(),
                        a.getTableId().getType()
                ));
            }

        }

        return list;
    }

    @Override
    public void saveCounterTableId(CounterTableReservationDTO onlineOrderDTO) {
        java.util.List<CounterTableReservationDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();
        String yo[] = arr.split(" ");
        int count = 0;
        CounterTableReservationDetailsDTO itm = new CounterTableReservationDetailsDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new CounterTableReservationDetailsDTO();
                itm.setTableId(Integer.parseInt(str));
                list.add(itm);
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        onlineOrderDTO.setDate(today);
        counterTableReservationDAO.save(new CounterTableReservation(

                onlineOrderDTO.getCounterTableReserveId(),
                Time.valueOf(onlineOrderDTO.getvStatT()),
                Time.valueOf(onlineOrderDTO.getvEndT()),
                3,
                Date.valueOf(onlineOrderDTO.getvDate())
        ));

        for (CounterTableReservationDetailsDTO orderDetail : list) {
            counterTableReservationDetailsDAO.save(new CounterTableReservationDetails(
                    onlineOrderDTO.getCounterTableReserveId(),
                    orderDetail.getTableId(),
                    0,
                    0
            ));

        }
    }

    @Override
    public void saveOnlineTableId(OnlineTableReservationDTO onlineOrderDTO) {
        java.util.List<OnlineTableReservationDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();

        String yo[] = arr.split(" ");
        int count = 0;
        OnlineTableReservationDetailsDTO itm = new OnlineTableReservationDetailsDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new OnlineTableReservationDetailsDTO();
                itm.setTableId(Integer.parseInt(str));
                list.add(itm);
                count = 0;

            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        onlineOrderDTO.setDate(today);
        onlineTableReservationDAO.save(new OnlineTableReservation(
                onlineOrderDTO.getOnlineTableReservationId(),
                Date.valueOf(onlineOrderDTO.getvDate()),
                onlineOrderDTO.getDate(),
                Time.valueOf(onlineOrderDTO.getvStatT()),
                Time.valueOf(onlineOrderDTO.getvEndT()),
                2,
                onlineCustomerDAO.findOne(onlineOrderDTO.getCustomer())));


        for (OnlineTableReservationDetailsDTO orderDetail : list) {
            onlineTableReservationDetailsDAO.save(new OnlineTableReservationDetails(
                    orderDetail.getTableId(),
                    onlineOrderDTO.getOnlineTableReservationId(),
                    0,
                    0));

        }
    }

    @Override
    public List<OnlineTableReservationDTO> findTablesOnline() {
        java.util.Date todaydate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable<OnlineTableReservation> all4 = onlineTableReservationDAO.findAllByReservedDateBetween(dt, todaydate);
        List<OnlineTableReservationDTO> tableDTOList = new ArrayList<>();
        for (OnlineTableReservation item : all4) {
            tableDTOList.add(new OnlineTableReservationDTO(
                    item.getOnlineTableReservationId(),
                    item.getDate(),
                    item.getStartTime(),
                    item.getEndTime()
            ));
        }
        return tableDTOList;
    }

    @Override
    public List<RestaurantOnlineOrderDTO> findOrderOnline() {
        java.util.Date todaydate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable<RestaurantOnlineOrder> all4 = onlineOrderDAO.findAllByDateBetween(dt, todaydate);
        List<RestaurantOnlineOrderDTO> tableDTOList = new ArrayList<>();
        for (RestaurantOnlineOrder item : all4) {
            tableDTOList.add(new RestaurantOnlineOrderDTO(
                    item.getOrderId(),
                    item.getOrderState(),
                    item.getDate(),
                    item.getCustomer().getOnlineCustomerId(),
                    item.getOrderDetails()
            ));
        }
        return tableDTOList;
    }


    @Override
    public RestaurantTableDTO findHighestTableId() {
        RestaurantTable lastItem = null;
        try {
            lastItem = restaurantTableDAO.findTopByOrderByTableIdDesc();
        } catch (Exception e) {
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

        for (RestaurantTable item : tables) {
            tableDTOList.add(new RestaurantTableDTO(
                    item.getTableId(),
                    item.getType(),
                    item.getUnitPrice()
            ));
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

    @Override
    public OnlineTableReservationDTO findHighestOnlineTableId() {
        OnlineTableReservation lastItem = null;
        try {
            lastItem = onlineTableReservationDAO.findTopByOrderByOnlineTableReservationIdDesc();
        } catch (Exception e) {

        }

        return new OnlineTableReservationDTO(lastItem.getOnlineTableReservationId());
    }

    @Override
    public CounterTableReservationDTO findHighestCounterTableId() {
        CounterTableReservation lastItem = null;
        try {
            lastItem = counterTableReservationDAO.findTopByOrderByCounterTableReserveIdDesc();
        } catch (Exception e) {

        }

        return new CounterTableReservationDTO(lastItem.getCounterTableReserveId());
    }


}