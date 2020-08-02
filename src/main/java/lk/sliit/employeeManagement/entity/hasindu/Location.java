package lk.sliit.employeeManagement.entity.hasindu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    private String locationId;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "locationTag", joinColumns = { @JoinColumn(name = "location") },inverseJoinColumns = { @JoinColumn(name = "menuId") })
    private List<Tag> location = new ArrayList<>();
    @OneToMany(mappedBy = "location", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<LocSesTag> locSesTags = new ArrayList<>();


    public Location(String locationId) {
        this.locationId = locationId;
    }

    public Location() {
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationId() {
        return locationId;
    }
}
