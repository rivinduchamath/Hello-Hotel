package lk.sliit.hotelManagement.controller.kitchenController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KitchenUtil {

    public static String ingredient = "Food Ingredient";
    public static String daily_B_MenuType = "Daily-breakfast";
    public static String daily_L_MenuType = "Daily-lunch";
    public static String daily_D_MenuType = "Daily-dinner";
    public static int defaultID = -1;
    public static String department = "Kitchen";

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

    private String getDateToday(){
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        String today= dateFormat.format(date);
        return today;
    }

    private String convertDateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private boolean isDateValid(Date date){
        String dateS = convertDateToString(date);
        String today = getDateToday();

        String[] dateParts = dateS.split("/");
        int dateD = Integer.parseInt(dateParts[0]);
        int dateM = Integer.parseInt(dateParts[1]);
        int dateY = Integer.parseInt(dateParts[2]);


        String[] todayParts = today.split("/");
        int todayD = Integer.parseInt(todayParts[0]);
        int todayM = Integer.parseInt(todayParts[1]);
        int todayY = Integer.parseInt(todayParts[2]);

        if (dateY < todayY){
            return false;
        } else if (dateY >= todayY){
            if (dateY == todayY && dateM < todayM){
                return false;
            } else if (dateY == todayY && dateM >= todayM){
                if (dateY == todayY && dateM == todayM && dateD < todayD){
                    return false;
                }
            }
        }

        return true;
    }

}
