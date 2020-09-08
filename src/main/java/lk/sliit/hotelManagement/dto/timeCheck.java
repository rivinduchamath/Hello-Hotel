package lk.sliit.hotelManagement.dto;

public class timeCheck {
    String id;
    String timeSett;

    public timeCheck(String id, String timeSett) {
        this.id = id;
        this.timeSett = timeSett;
    }

    public timeCheck() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeSett() {
        return timeSett;
    }

    public void setTimeSett(String timeSett) {
        this.timeSett = timeSett;
    }

    @Override
    public String toString() {
        return "timeCheck{" +
                "id='" + id + '\'' +
                ", timeSett='" + timeSett + '\'' +
                '}';
    }
}
