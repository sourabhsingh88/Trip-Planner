package com.amstech.tripplanner.booking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tripplanner")
public class TripPlannerController {

	public TripPlannerController() {
		System.out.println("TripPlannerController :  Object Created" );
	}
	
}
