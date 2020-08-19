package lk.sliit.hotelManagement.entity.kitchen;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MenuDetailsPK implements Serializable {

    private String menu;
    private String foodItem;

    public MenuDetailsPK() {
    }

    public MenuDetailsPK(String menu, String foodItem) {
        this.menu = menu;
        this.foodItem = foodItem;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }
}