package lk.sliit.hotelManagement.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Limit {
@Id
    private String limitId;
private String limitName;
private double limit;

    public Limit(String limitId, String limitName, double limit) {
        this.limitId = limitId;
        this.limitName = limitName;
        this.limit = limit;
    }

    public Limit() {
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getLimitName() {
        return limitName;
    }

    public void setLimitName(String limitName) {
        this.limitName = limitName;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
