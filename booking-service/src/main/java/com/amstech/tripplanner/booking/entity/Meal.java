package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the meal database table.
 * 
 */
@Entity
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to TripDetail
	@OneToMany(mappedBy="meal")
	private List<TripDetail> tripDetails;

	public Meal() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TripDetail> getTripDetails() {
		return this.tripDetails;
	}

	public void setTripDetails(List<TripDetail> tripDetails) {
		this.tripDetails = tripDetails;
	}

	public TripDetail addTripDetail(TripDetail tripDetail) {
		getTripDetails().add(tripDetail);
		tripDetail.setMeal(this);

		return tripDetail;
	}

	public TripDetail removeTripDetail(TripDetail tripDetail) {
		getTripDetails().remove(tripDetail);
		tripDetail.setMeal(null);

		return tripDetail;
	}

}