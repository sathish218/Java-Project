package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.Busdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusdetailsRepository extends JpaRepository<Busdetails, Long> {


    List<Busdetails> findByFromPlaceAndToPlaceAndDepartureDate(String fromPlace, String toPlace, LocalDate departureDate);

    // Custom query using @Query annotation
//    @Query("SELECT b FROM Busdetails b WHERE b.fromPlace = :fromPlace AND b.toPlace = :toPlace AND b.departureDate = :departureDate")
//    List<Busdetails> findBusesByRouteAndDate(@Param("fromPlace") String fromPlace,
//                                             @Param("toPlace") String toPlace,
//                                             @Param("departureDate") LocalDate departureDate);
}
