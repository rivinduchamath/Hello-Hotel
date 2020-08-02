package lk.sliit.employeeManagement.entity.hasindu;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Session {
    @Id
    private String sessionId;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "SessionTag", joinColumns = { @JoinColumn(name = "Tag") },inverseJoinColumns = { @JoinColumn(name = "menuId") })
    private List<Tag> tag = new ArrayList<>();
    @OneToMany(mappedBy = "session", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<LocSesTag> locSesTags = new ArrayList<>();

    public Session() {
    }

    public Session(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
