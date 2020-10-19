package lk.sliit.hotelManagement.dto.restaurant;

public class OnlineCustomerLocationsDTO {
    private int locationId;
    private String locationNames;

    public OnlineCustomerLocationsDTO(int locationId, String locationNames) {
        this.locationId = locationId;
        this.locationNames = locationNames;
    }

    public OnlineCustomerLocationsDTO() {
    }

    public OnlineCustomerLocationsDTO(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationNames() {
        return locationNames;
    }

    public void setLocationNames(String locationNames) {
        this.locationNames = locationNames;
    }

    @Override
    public String toString() {
        return "OnlineCustomerLocationsDTO{" +
                "locationId=" + locationId +
                ", locationNames='" + locationNames + '\'' +
                '}';
    }
}
