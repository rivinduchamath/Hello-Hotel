package lk.sliit.hotelManagement.entity.restaurant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OnlineLocation {
    @Id
    private int locationId;
    private String location;

    public OnlineLocation(int locationId, String location) {
        this.locationId = locationId;
        this.location = location;
    }

    public OnlineLocation() {
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
