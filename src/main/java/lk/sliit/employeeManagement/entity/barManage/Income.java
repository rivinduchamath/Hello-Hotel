package lk.sliit.employeeManagement.entity.barManage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Income {
    @Id
    private String incomeId;
    private double income;

    private String billId;
}
