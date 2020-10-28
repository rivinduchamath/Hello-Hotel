package lk.sliit.hotelManagement.controller.kitchenController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KitchenUtil {

    public static final String daily_B_MenuType = "Daily-breakfast";
    public static final String daily_L_MenuType = "Daily-lunch";
    public static final String daily_D_MenuType = "Daily-dinner";
    public static final int defaultID = -1;
    public static final String department = "Kitchen";
    public static final String dailyMenuDate = "dailyMenuDate";
    public static final String stringSeperator = "/";
    public static final String dateSeperator = "-";
    public static final double kitchenMenuDate = -500.765;
    public static final String emptyMenuName = "Menu is empty.";
    public static final String emptyItemList = "List is empty.";
    public static final String emptyFoodItem = "Food item is empty";
    public static final String dailyFoodOrderType = "Daily";
    public static final String banquetFoodOrderType = "Banquet";
    public static final String alertMessageName = "alert";
    public static final String confimedBanquet = "ConfirmedBanquet";
    public static final String processingState = "Processing";
    public static final String pendingState = "Pending";
    public static final String canceledState = "Canceled";
    public static final String finishedState = "Finished";
    public static final String onlineType = "Online";
    public static final String counterType = "Counter";
    public static final String confirm = "Confirm";
    public static final String accept = "Accept";

    public static String[] foodItemCategories = {

            "Appetizers",
            "Sandwiches",
            "Mains",
            "Rice & Noodles",
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
