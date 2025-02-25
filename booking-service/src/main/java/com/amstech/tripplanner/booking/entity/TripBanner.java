package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the trip_banner database table.
 * 
 */
@Entity
@Table(name="trip_banner")
@NamedQuery(name="TripBanner.findAll", query="SELECT t FROM TripBanner t")
public class TripBanner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String url;

	//bi-directional many-to-one association to TripDetail
	@OneToMany(mappedBy="tripBanner")
	private List<TripDetail> tripDetails;

	public TripBanner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TripDetail> getTripDetails() {
		return this.tripDetails;
	}

	public void setTripDetails(List<TripDetail> tripDetails) {
		this.tripDetails = tripDetails;
	}

	public TripDetail addTripDetail(TripDetail tripDetail) {
		getTripDetails().add(tripDetail);
		tripDetail.setTripBanner(this);

		return tripDetail;
	}

	public TripDetail removeTripDetail(TripDetail tripDetail) {
		getTripDetails().remove(tripDetail);
		tripDetail.setTripBanner(null);

		return tripDetail;
	}

}