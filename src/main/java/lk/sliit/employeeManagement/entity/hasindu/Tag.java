package lk.sliit.employeeManagement.entity.hasindu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    private String tagId;
    @ManyToMany(mappedBy = "tag")
    private List<Session> Tag = new ArrayList<>();
    @ManyToMany(mappedBy = "location")
    private List<Location> location = new ArrayList<>();
    @OneToMany(mappedBy = "tag", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<LocSesTag> locSesTags = new ArrayList<>();

    public Tag(String tagId) {
        this.tagId = tagId;
    }

    public Tag() {
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

}
