package lk.sliit.employeeManagement.entity.hasindu;


import javax.persistence.*;

@Entity
public class LocSesTag {

    @EmbeddedId
    private LocSesTagPK locSesTagPK;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="locationId",referencedColumnName = "locationId", insertable = false, updatable = false)
    private Location location;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="sessionId",referencedColumnName = "sessionId", insertable = false, updatable = false)
    private Session session;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="tagId",referencedColumnName = "tagId", insertable = false, updatable = false)
    private Tag tag;


    public LocSesTag(LocSesTagPK locSesTagPK) {
        this.locSesTagPK = locSesTagPK;
    }
    public LocSesTag(String locationId,String sessionId, String tagId ) {
        this.locSesTagPK = new LocSesTagPK(locationId,sessionId,tagId);
    }

    public LocSesTag() {
    }

    public LocSesTagPK getLocSesTagPK() {
        return locSesTagPK;
    }

    public void setLocSesTagPK(LocSesTagPK locSesTagPK) {
        this.locSesTagPK = locSesTagPK;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
