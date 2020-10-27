package lk.sliit.hotelManagement.dto.banquet;

public class LimitDTO {
    private int limitId;
    private String limitName;
    private double limit;

    public LimitDTO(int limitId, String limitName, double limit) {
        this.limitId = limitId;
        this.limitName = limitName;
        this.limit = limit;
    }

    public LimitDTO() {
    }

    public int getLimitId() {
        return limitId;
    }

    public void setLimitId(int limitId) {
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

    @Override
    public String toString() {
        return "LimitDTO{" +
                "limitId='" + limitId + '\'' +
                ", limitName='" + limitName + '\'' +
                ", limit=" + limit +
                '}';
    }
}
