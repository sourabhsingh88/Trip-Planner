package com.amstech.tripplanner.booking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amstech.tripplanner.booking.entity.TripDetail;

public interface TripDetailRepo extends JpaRepository<TripDetail, Integer> {

}
