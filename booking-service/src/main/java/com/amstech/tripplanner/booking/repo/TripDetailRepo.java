package com.amstech.tripplanner.booking.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amstech.tripplanner.booking.entity.TripDetail;



public interface TripDetailRepo extends JpaRepository<TripDetail, Integer >{

//	 @Query("SELECT td FROM TripDetail td JOIN FETCH td.trip t WHERE t.id = :trip_id")
//	    Optional<TripDetail> findByTripId(@Param("trip_id") int trip_id);
	
}