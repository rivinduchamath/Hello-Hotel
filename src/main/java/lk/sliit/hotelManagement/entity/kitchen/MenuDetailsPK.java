package lk.sliit.hotelManagement.entity.kitchen;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MenuDetailsPK implements Serializable {

    private int menu;
    private int foodItem;

    public MenuDetailsPK() {
    }

    public MenuDetailsPK(int menu, int foodItem) {
        this.menu = menu;
        this.foodItem = foodItem;
    }

    public int getMenu() {
        return menu;
    }

    public void setMenu(int menu) {
        this.menu = menu;
    }

    public int getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(int foodItem) {
        this.foodItem = foodItem;
    }
}