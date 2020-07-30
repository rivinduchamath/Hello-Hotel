package lk.sliit.employeeManagement.entity.restaurant.counterTableReservation;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetailPK;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CounterTableReservationDetails {
    @EmbeddedId
    private CounterTableReservationDetailsPK counterTableReservationDetailsPK;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "counterTableReserveId", referencedColumnName = "counterTableReserveId", insertable = false, updatable = false)
    private CounterTableReservation counterTableReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;

    public CounterTableReservationDetails(CounterTableReservationDetailsPK restaurantCounterOrderDetailPK) {
        this.counterTableReservationDetailsPK = restaurantCounterOrderDetailPK;
    }
    public CounterTableReservationDetails(String counterTableReserveId,String foodItemId) {
        this.counterTableReservationDetailsPK = new CounterTableReservationDetailsPK(counterTableReserveId,foodItemId);
    }
    public CounterTableReservationDetails() {
    }

    public CounterTableReservationDetailsPK getCounterTableReservationDetailsPK() {
        return counterTableReservationDetailsPK;
    }

    public void setCounterTableReservationDetailsPK(CounterTableReservationDetailsPK counterTableReservationDetailsPK) {
        this.counterTableReservationDetailsPK = counterTableReservationDetailsPK;
    }

    public CounterTableReservation getCounterTableReservation() {
        return counterTableReservation;
    }

    public void setCounterTableReservation(CounterTableReservation counterTableReservation) {
        this.counterTableReservation = counterTableReservation;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}

