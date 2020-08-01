package lk.sliit.employeeManagement.entity.restaurant.onlineTableReservation;

import lk.sliit.employeeManagement.entity.kitchen.FoodItem;

import javax.persistence.*;

@Entity
public class OnlineTableReservationDetails {
    @EmbeddedId
    private OnlineTableReservationDetailsPK onlineTableReservationDetailsPK;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "onlineTableId", referencedColumnName = "onlineTableId", insertable = false, updatable = false)
    private OnlineTableReservation onlineTableReservation;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "foodItemId", referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;

    public OnlineTableReservationDetails(OnlineTableReservationDetailsPK onlineTableReservationDetailsPK, OnlineTableReservation onlineTableReservation, FoodItem foodItem) {
        this.onlineTableReservationDetailsPK = onlineTableReservationDetailsPK;
        this.onlineTableReservation = onlineTableReservation;
        this.foodItem = foodItem;
    }
    public OnlineTableReservationDetails(String foodItemId, String onlineTableId, FoodItem foodItem) {
        this.onlineTableReservationDetailsPK = new OnlineTableReservationDetailsPK(foodItemId,onlineTableId);
    }

    public OnlineTableReservationDetails() {
    }

    public OnlineTableReservationDetailsPK getOnlineTableReservationDetailsPK() {
        return onlineTableReservationDetailsPK;
    }

    public void setOnlineTableReservationDetailsPK(OnlineTableReservationDetailsPK onlineTableReservationDetailsPK) {
        this.onlineTableReservationDetailsPK = onlineTableReservationDetailsPK;
    }

    public OnlineTableReservation getOnlineTableReservation() {
        return onlineTableReservation;
    }

    public void setOnlineTableReservation(OnlineTableReservation onlineTableReservation) {
        this.onlineTableReservation = onlineTableReservation;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}

