package lk.sliit.hotelManagement.service.custom;

import lk.sliit.hotelManagement.dto.banquet.BanquetAddDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetBillDTO;
import lk.sliit.hotelManagement.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotelManagement.dto.beverage.BarOrderDTO;
import lk.sliit.hotelManagement.dto.reservation.CustomerDTO;
import lk.sliit.hotelManagement.service.SuperBO;

import java.util.List;

public interface BanquetBO extends SuperBO {

    void saveBanquet(BanquetAddDTO banquetAddDTO);

    BanquetOrderDTO findTopBanquetId();

    CustomerDTO findTopCustomerId();

    BanquetBillDTO findTopBanquetBillId();

    List<CustomerDTO> findAllCustomers();

    List<BanquetAddDTO> findAllBanquet();

    List<BanquetAddDTO> findNextBanquets();

    void updateBanquetStatus(String orderId);

    List<BanquetAddDTO> findTodayBanquets();

    void updateBanquetDetails(BanquetAddDTO banquetAddDTO);

    List<BanquetAddDTO> findUnconfirmedBanquet();

    List<BanquetAddDTO> findConfirmedBanquet();

    void updateBanquetStatusToCancel(String orderId);

    void deleteBanquet(String idNo);
}
