package lk.sliit.employeeManagement.entity.restaurant.counterTableReservation;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;
import lk.sliit.employeeManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetailPK;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CounterTableReservationDetailsPK implements Serializable {
    private String foodItemId;
    private  String counterTableReserveId;

    public CounterTableReservationDetailsPK(String foodItemId, String counterTableReserveId) {
        this.foodItemId = foodItemId;
        this.counterTableReserveId = counterTableReserveId;
    }

    public CounterTableReservationDetailsPK() {
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(String counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }
}

