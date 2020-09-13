package lk.sliit.hotelManagement.dao;

import lk.sliit.hotelManagement.entity.TimeCheck;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.Date;

public interface TimeDAO extends CrudRepository<TimeCheck, String> {

    //Iterable<OnlineTableReservation> findOnlineTableReservationsByStartTimeBeforeAndEndTimeAfterAndDateEquals(Time startTime, Time endTime, Date date);

   // Iterable<OnlineTableReservation> findOnlineTableReservationsByDateEquals(Date date);


   //Iterable<TimeCheck> findTimeChecksByTimeSettBeforeAndTimeSett2AfterAndDateEquals(Date tdate, Date tdate2, Date date);


//    @Query(value = "SELECT e FROM TimeCheck e WHERE e.timeSett BETWEEN :startDate AND :endDate order by e.joinDate")
//   +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    Iterable<TimeCheck> findAllByTimeTwoGreaterThanEqualAndTimeOneLessThanEqualAndDateEquals(Date tdate, Date tdate2, Date date);
    Iterable<TimeCheck> findAllByTimeTwoBetweenAndDateEquals(Date tdate, Date tdate2, Date date);
    Iterable<TimeCheck> findAllByTimeOneBetweenAndDateEquals(Date tdate, Date tdate2, Date date);

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//    Iterable<TimeCheck> findAllByTimeTwoLessThanEqualAndTimeOneGreaterThanEqualAndDateEquals(Date tdate2, Date tdate, Date date);
//    Iterable<TimeCheck> findAllByTimeOneLessThanEqualAndTimeTwoGreaterThanEqualAndDateEquals(Date tdate2, Date tdate, Date date);

//    @Query(value =" from TimeCheck where ((timeOne between  timeOne and timeTwo) or (timeTwo between timeOne and timeTwo))")
//    Iterable<TimeCheck> uals(Date tdate,Date tdate2, Date date);


    //Iterable<TimeCheck> findTimeChecksByTimeOneIsInOrTimeTwoIsInAndDateEquals(Date tdate, Date tdate2, Date date);

   // Iterable<TimeCheck>  findTimeChecksByTimeOneSinceGreaterThanEqualAndUntilLessThanEqual(Long since, Long until);

   // Iterable<TimeCheck> findAllByTimeOneAndTimeTwoNotContainingInTimeOneGreaterThanEqualAndTimeTwoLessThanEqualAndDateEquals(Date tdate, Date tdate2, Date date);

//    @Query(value = "FROM TimeCheck e WHERE e.timeOne  BETWEEN e.timeOne AND e.timeTwo",nativeQuery = false)
//    Iterable<TimeCheck> getAllBetweenDates( @Param("startDate")Date tdate, @Param("endDate")Date tdate2,@Param("date")Date date);
}

  /*  @Query( value = "SELECT admin FROM emp2.Employee WHERE idNo=?1",nativeQuery = true)
    boolean isAdmin(String idNo);*/