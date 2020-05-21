package lk.sliit.employeeManagement.dto;

import java.sql.Date;

public class FoodAndBeverageDTO  {

    private String foodId ;
    private String text;
    private String description;
    private Date date;

    public FoodAndBeverageDTO(String foodId, String text, String description, Date date) {
        this.foodId = foodId;
        this.text = text;
        this.description = description;
        this.date = date;
    }

    public FoodAndBeverageDTO() {
    }

    public String getBanquetId() {
        return foodId;
    }

    public void setBanquetId(String foodId) {
        this.foodId = foodId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FoodAndBeverageDTO{" +
                "foodId='" + foodId + '\'' +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}//End Class
