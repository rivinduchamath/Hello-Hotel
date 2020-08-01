package lk.sliit.employeeManagement.entity.restaurant.onlineTableReservation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OnlineTableReservationDetailsPK implements Serializable {

    private String foodItemId;
    private  String onlineTableId;

    public OnlineTableReservationDetailsPK(String foodItemId, String onlineTableId) {
        this.foodItemId = foodItemId;
        this.onlineTableId = onlineTableId;
    }

    public OnlineTableReservationDetailsPK() {
    }

    public String getOnlineTableId() {
        return onlineTableId;
    }

    public void setOnlineTableId(String onlineTableId) {
        this.onlineTableId = onlineTableId;
    }

    public String getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(String foodItemId) {
        this.foodItemId = foodItemId;
    }
}
