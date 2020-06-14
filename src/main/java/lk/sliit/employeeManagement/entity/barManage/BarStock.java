package lk.sliit.employeeManagement.entity.barManage;

import lk.sliit.employeeManagement.entity.SuperEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BarStock implements SuperEntity {
    @Id
    private String productId;
    private String productName;
    private int currentAmmount;
    private int amountForUnit;
    private double pricePerUnit;
    private int unitCount;

    public BarStock() {
    }

    public BarStock(String productId, String productName,
                    int currentAmmount, int amountForUnit,
                    double pricePerUnit, int unitCount) {
        this.productId = productId;
        this.productName = productName;
        this.currentAmmount = currentAmmount;
        this.amountForUnit = amountForUnit;
        this.pricePerUnit = pricePerUnit;
        this.unitCount = unitCount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCurrentAmmount() {
        return currentAmmount;
    }

    public void setCurrentAmmount(int currentAmmount) {
        this.currentAmmount = currentAmmount;
    }

    public int getAmountForUnit() {
        return amountForUnit;
    }

    public void setAmountForUnit(int amountForUnit) {
        this.amountForUnit = amountForUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }
}
