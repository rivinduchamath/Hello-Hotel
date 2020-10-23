package lk.sliit.hotelManagement.dto.kitchen;

public class MenuDetailsDTO {

    private int foodItemID;
    private int menuID;

    public MenuDetailsDTO() {
    }

    public MenuDetailsDTO(int menuID, int foodItemID) {
        this.menuID = menuID;
        this.foodItemID = foodItemID;
    }

    public int getMenuID() {
        return menuID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }
}
