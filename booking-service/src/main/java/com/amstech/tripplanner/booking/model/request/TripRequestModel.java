package com.amstech.tripplanner.booking.model.request;

import java.util.List;

import com.amstech.tripplanner.booking.entity.Accommodation;
import com.amstech.tripplanner.booking.entity.Activity;
import com.amstech.tripplanner.booking.entity.Meal;
import com.amstech.tripplanner.booking.entity.Transport;
import com.amstech.tripplanner.booking.entity.Trip;
import com.amstech.tripplanner.booking.entity.TripBanner;

public class TripRequestModel {

		private Trip trip;
	    private List<Accommodation> accommodations;
	    private List<Transport> transports;
	    private List<Activity> activities;
	    private List<Meal> meals;
	    private List<TripBanner> banners;
	
}
