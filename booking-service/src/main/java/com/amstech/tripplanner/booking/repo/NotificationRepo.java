package com.amstech.tripplanner.booking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amstech.tripplanner.booking.entity.Notification;
import com.amstech.tripplanner.booking.entity.TripDetail;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {


	@Query("select n from Notification n where n.userId =:userId and n.tripDetail=:tripDetail")
	Notification findbyUserIdTripDetailId(@Param("userId") int userId,@Param("tripDetail") TripDetail tripDetail);

	@Query("select n from Notification n where n.userId =:userId")
	List<Notification> findbyUserId(@Param("userId") int userId);

}
