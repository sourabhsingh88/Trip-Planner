package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trip_planner database table.
 * 
 */
@Entity
@Table(name="trip_planner")
@NamedQuery(name="TripPlanner.findAll", query="SELECT t FROM TripPlanner t")
public class TripPlanner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String bio;

	@Column(name="company_name")
	private String companyName;

	private int experience;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to TripDetail
	@OneToMany(mappedBy="tripPlanner")
	private List<TripDetail> tripDetails;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	public TripPlanner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<TripDetail> getTripDetails() {
		return this.tripDetails;
	}

	public void setTripDetails(List<TripDetail> tripDetails) {
		this.tripDetails = tripDetails;
	}

	public TripDetail addTripDetail(TripDetail tripDetail) {
		getTripDetails().add(tripDetail);
		tripDetail.setTripPlanner(this);

		return tripDetail;
	}

	public TripDetail removeTripDetail(TripDetail tripDetail) {
		getTripDetails().remove(tripDetail);
		tripDetail.setTripPlanner(null);

		return tripDetail;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}