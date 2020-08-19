package lk.sliit.hotelManagement.dto.houseKeeping;

public class LaundryBillDTO {
    private String laundryBillId;
    private double pieces;
   private String customerId;

    public LaundryBillDTO(String laundryBillId, double pieces, String customerId) {
        this.laundryBillId = laundryBillId;
        this.pieces = pieces;
        this.customerId = customerId;
    }

    public LaundryBillDTO() {
    }

    public String getLaundryBillId() {
        return laundryBillId;
    }

    public void setLaundryBillId(String laundryBillId) {
        this.laundryBillId = laundryBillId;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "LaundryBillDTO{" +
                "laundryBillId='" + laundryBillId + '\'' +
                ", pieces=" + pieces +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
