package com.amstech.tripplanner.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.amstech.tripplanner.booking.entity.TripDetail;
import com.amstech.tripplanner.booking.model.response.TripDetailResponseModel;
import com.amstech.tripplanner.booking.model.response.TripResponseModel;
import com.amstech.tripplanner.booking.repo.TripDetailRepo;

@Service
public class TripDetailService {

	@Autowired
	public TripDetailRepo tripDetailRepo;

	public void tripDetailService() {
		System.out.println("tripDetails service object created");
	}

//	***************************   API FIND  FULL TRIPS DETAIL ***************************

	public List<TripDetailResponseModel> getAllTripDetail() throws Exception {
		List<TripDetail> tripDetailList = tripDetailRepo.findAll();

		List<TripDetailResponseModel> tripResponseModels = new ArrayList<TripDetailResponseModel>();
		
		for (TripDetail tripDetail : tripDetailList) {
			TripDetailResponseModel responseModel = new TripDetailResponseModel();
			System.out.println("object created");
			responseModel.setAccommodationId(tripDetail.getAccommodation().getId());
			responseModel.setStatusId(tripDetail.getStatus().getId());
			tripResponseModels.add(responseModel);
		}
		return tripResponseModels;

	}
	
//	***************************   API FIND  FULL TRIPS DETAIL ***************************
	
	
	public TripDetail getTripDetailByTripId(int trip_id) {
        return tripDetailRepo.findById(trip_id)
                .orElseThrow(() -> new RuntimeException("Trip not found for ID: " + trip_id));
    }
}
