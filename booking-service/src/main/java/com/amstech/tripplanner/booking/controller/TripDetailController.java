package com.amstech.tripplanner.booking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.amstech.tripplanner.booking.entity.TripDetail;
import com.amstech.tripplanner.booking.model.response.TripDetailResponseModel;
import com.amstech.tripplanner.booking.model.response.TripResponseModel;
import com.amstech.tripplanner.booking.repo.TripDetailRepo;
import com.amstech.tripplanner.booking.service.TripDetailService;

@RestController
@RequestMapping("/tripDetail")
public class TripDetailController {
@Autowired
	private TripDetailService tripDetailService;


private TripDetailRepo tripDetailRepo ;
	public TripDetailController() {
		System.out.println("Trip detail Controller : object Created ");
		// TODO Auto-generated constructor stub
	}
	
	
//	***************************   TRIP DETAIL     ***************************

	@RequestMapping(method = RequestMethod.GET, value = "/findAllDetail", produces = "application/json")
	public ResponseEntity<Object> findAllDetail() {
		System.out.println("fetching all trip details");

		try {
			List<TripDetailResponseModel> tripDetailResponseModels = tripDetailService.getAllTripDetail();
			return new ResponseEntity<Object>(tripDetailResponseModels, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Failed to fetch tripDetail due to " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	public List<TripDetail> getAllDetails() {
//		return tripDetailService.getAllTrips();
//
//	}
	
//	***************************   TRIP DETAIL     ***************************
	
	
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/findTripDetailById", produces = "application/json")

	  @GetMapping("/{trip_id}")
	    public TripDetail getTripDetail(@PathVariable("trip_id") int trip_id) {
	        return tripDetailService.getTripDetailByTripId(trip_id);
	    }
	  
	 
}
