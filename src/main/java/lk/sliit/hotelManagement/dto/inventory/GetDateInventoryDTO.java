package lk.sliit.hotelManagement.dto.inventory;

import java.sql.Date;

public class GetDateInventoryDTO {
    private Date dateIn;
    private Date dateOut;


    public GetDateInventoryDTO(Date dateIn, Date dateOut) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }


    public GetDateInventoryDTO() {
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "GetDateInventoryDTO{" +
                "dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }
}
