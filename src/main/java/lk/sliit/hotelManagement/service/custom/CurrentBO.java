package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.hr.CurrentBillDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface CurrentBO extends SuperBO {
    CurrentBillDTO findHighestCurrentBillId();

    void saveCurrentBill(CurrentBillDTO currentBillDTO);

    List<CurrentBillDTO> findAllCurrentBills();

    CurrentBillDTO findById(int billId);

    void deleteCurrentBill(int billId);
}
