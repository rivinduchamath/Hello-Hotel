package lk.sliit.hotelManagement.service.custom.impl;

import lk.sliit.hotelManagement.dao.hrDAO.CurrentBillDAO;
import lk.sliit.hotelManagement.dto.hr.CurrentBillDTO;
import lk.sliit.hotelManagement.dto.manager.NoticeDTO;
import lk.sliit.hotelManagement.entity.hr.CurrentBill;
import lk.sliit.hotelManagement.entity.manager.Notice;
import lk.sliit.hotelManagement.service.custom.CurrentBO;
import lk.sliit.hotelManagement.service.custom.HumanResourceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CurrentBOImpl implements CurrentBO {

    @Autowired
    CurrentBillDAO currentBillDAO;


    @Override
    public void saveCurrentBill(CurrentBillDTO currentBillDTO) {
        currentBillDAO.save(new CurrentBill(
                currentBillDTO.getBillId(),
                currentBillDTO.getAmount(),
                currentBillDTO.getDate()
        ));
    }

    @Override
    @Transactional (readOnly = true)
    public List<CurrentBillDTO> findAllCurrentBills() {
        Iterable<CurrentBill> currentBillDetails = currentBillDAO.findAll();
        List<CurrentBillDTO> currentBillDTOS = new ArrayList<>();
        for (CurrentBill cb: currentBillDetails) {
            currentBillDTOS.add(new CurrentBillDTO(
                    cb.getBillId(),
                    cb.getAmount(),
                    cb.getDate()
            ));
        }
        return currentBillDTOS;
    }

    @Override
    public CurrentBillDTO findById(int billId) {
        CurrentBill currentBill = currentBillDAO.findOne(billId);
        return new CurrentBillDTO(
                currentBill.getBillId(),
                currentBill.getAmount(),
                currentBill.getDate()
        );
    }

    @Override
    public CurrentBillDTO findHighestCurrentBillId() {
        CurrentBill lastCurrentBillId = null;
        try{
            lastCurrentBillId = currentBillDAO.findTopByOrderByBillIdDesc();
            System.out.println(lastCurrentBillId);
        }catch(Exception e){

        }
        assert lastCurrentBillId != null;
        return new CurrentBillDTO(
                lastCurrentBillId.getBillId()
        );
    }
}
