package lk.sliit.hotelManagement.controller.kitchenController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KitchenUtil {

    public static String ingredient = "Rice & Noodles";
    public static String daily_B_MenuType = "Daily-breakfast";
    public static String daily_L_MenuType = "Daily-lunch";
    public static String daily_D_MenuType = "Daily-dinner";
    public static int defaultID = -1;
    public static String department = "Kitchen";
    public static String dailyMenuDate = "dailyMenuDate";
    public static String stringSeperator = "/";
    public static String dateSeperator = "-";
    public static double kitchenMenuDate = -500.765;
    public static String emptyMenuName = "Menu is empty.";
    public static String emptyItemList = "List is empty.";
    public static String emptyFoodItem = "Food item is empty";

    public static String[] foodItemCategories = {
            ingredient,
            "Appetizers",
            "Sandwiches",
            "Mains",
            "Desserts"
    };


    public static String[] menuCategories = {
            "Bronze",
            "Silver",
            "Gold",
            "Platinum",
            daily_B_MenuType,
            daily_L_MenuType,
            daily_D_MenuType,
            "Restaurant"
    };

}
