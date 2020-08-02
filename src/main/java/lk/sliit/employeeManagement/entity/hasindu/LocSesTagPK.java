package lk.sliit.employeeManagement.entity.hasindu;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LocSesTagPK implements Serializable {
private String locationId;
private String sessionId;
private String tagId;

    public LocSesTagPK(String locationId, String sessionId, String tagId) {
        this.locationId = locationId;
        this.sessionId = sessionId;
        this.tagId = tagId;
    }

    public LocSesTagPK() {
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
}
