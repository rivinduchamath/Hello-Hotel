package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetBillDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.Date;
import java.util.List;

public interface BanquetBO extends SuperBO {

    void saveBanquet(BanquetAddDTO banquetAddDTO);

    BanquetOrderDTO findTopBanquetId();

    CustomerDTO findTopCustomerId();

    BanquetBillDTO findTopBanquetBillId();

    List<CustomerDTO> findAllCustomers();

    List<BanquetAddDTO> findAllBanquet();

    List<BanquetAddDTO> findNextBanquets();

    void updateBanquetStatus(int orderId);

    List<BanquetAddDTO> findTodayBanquets();

    void updateBanquetDetails(BanquetAddDTO banquetAddDTO);

    List<BanquetAddDTO> findUnconfirmedBanquet();

    List<BanquetAddDTO> findConfirmedBanquet();

    void updateBanquetStatusToCancel(int orderId);

    int checkAvailability(Date date);

    int checkHall1Availability(Date date);

    int checkHall2Availability(Date date);

    List<BanquetAddDTO> findCheckDateBanquets(Date date);

    List<BanquetAddDTO> findBanquetBill();

    void deleteBanquet(int idNo);

    void updateBill(BanquetAddDTO banquetAddDTO);

    void updateBanquetStatusAsFinished(int orderId);

    List<BanquetAddDTO> findLastWeakBanquets();

    int checkHall1AvailabilityAndGetBanquetId(Date date);

    int checkHall2AvailabilityAndGetBanquetId(Date date);

    BanquetAddDTO findBanquetBillById(int billId);
}
