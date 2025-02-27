package com.amstech.tripplanner.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.amstech.tripplanner.booking.entity.TripDetail;
import com.amstech.tripplanner.booking.model.response.TripResponseModel;
import com.amstech.tripplanner.booking.service.TripDetailService;
import com.amstech.tripplanner.booking.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

	@Autowired
	private TripService tripService;
	

	public TripController() {
		System.out.println("Trip Controller : object Created ");
		// TODO Auto-generated constructor stub
	}

//					***************************   API FIND ALL TRIPS ((SEARCH))   ***************************

	@RequestMapping(method = RequestMethod.GET, value = "/findAllTrip", produces = "application/json")
	public ResponseEntity<Object> findAllTrip() {
		System.out.println("fetching all trips");

		try {
			List<TripResponseModel> tripResponseModels = tripService.findAllTrip();
			return new ResponseEntity<Object>(tripResponseModels, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Failed to fetch trip due to " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
//	@RequestMapping(method = RequestMethod.GET, value = "/findAll", consumes = "application/json", produces = "application/json")
//	public List<TripResponseModel> findAll() throws Exception {
//		System.out.println("findAll");
//		return tripService.findAll();
//	}

	
	
//	***************************   API FIND  TRIPS BY NAME  ((SEARCH BY NAME ))   ***************************

//	@RequestMapping(method = RequestMethod.GET, value = "/search", produces = "application/json")
//	public ResponseEntity<Object> SearchByName(@RequestParam("name") String name) {
//		System.out.println("fetching trip data by name :" + name);
//		try {
//			TripResponseModel tripResponseModel = tripService.findByName(name);
//			return new ResponseEntity<Object>(tripResponseModel, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//			return new ResponseEntity<Object>("Failed to fetch trip due to " + e.getMessage(),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/findById" , consumes = "application/json"  , produces = "application/json")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id){
		System.out.println("fetching trip data by name :" + id) ;
		try {
			TripResponseModel tripResponseModel = tripService.findById(id) ;
			return new ResponseEntity<Object>(tripResponseModel, HttpStatus.OK);
		} catch (Exception e) { 
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Failed to fetch trip due to " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
//	@RequestMapping(method = RequestMethod.GET, value = "/findByName", consumes = "application/json", produces = "application/json")
//	public List<TripResponseModel> findByName(@RequestParam("name") String name) throws Exception {
//		System.out.println("findByName");
//		return tripService.findByName(name) ;
//	}
//	***************************   API CONTINUE AND DISCONTINUE  ***************************

	 @PutMapping("/{id}/toggle-status")
	    public String toggleTripStatus(@PathVariable Integer id) {
	        return tripService.toggleTripStatus(id);
	    }

	
	
}
