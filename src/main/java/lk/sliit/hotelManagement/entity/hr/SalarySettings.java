package lk.sliit.hotelManagement.entity.hr;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class SalarySettings {
    @Id
    private int id;
    private double etf;
    private double epf;
    private double serviceCharge;
    private Date date;

    public SalarySettings(int id, double etf, double epf, double serviceCharge, Date date) {
        this.id = id;
        this.etf = etf;
        this.epf = epf;
        this.serviceCharge = serviceCharge;
        this.date = date;
    }

    public SalarySettings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEtf() {
        return etf;
    }

    public void setEtf(double etf) {
        this.etf = etf;
    }

    public double getEpf() {
        return epf;
    }

    public void setEpf(double epf) {
        this.epf = epf;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

