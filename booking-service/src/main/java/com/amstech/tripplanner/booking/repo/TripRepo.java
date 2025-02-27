package com.amstech.tripplanner.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.amstech.tripplanner.booking.entity.Trip;

import jakarta.transaction.Transactional;

@Repository
public interface TripRepo extends JpaRepository<Trip, Integer> {

//	@Query("select e from Trip e where e.name = :name")
//	Trip findByName(@Param("Name") String name ) ;

//	@Transactional
//	@Modifying
//	@Query("UPDATE Trip t SET t.status = :status WHERE t.id = :id")
//	void updateTripStatus(Long id, String status);
}
