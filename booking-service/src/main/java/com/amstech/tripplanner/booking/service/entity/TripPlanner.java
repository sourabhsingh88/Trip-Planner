package com.amstech.tripplanner.booking.service.entity;

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

	@Id
	private int id;

	@Lob
	private String bio;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private int experience;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to Trippackage
	@OneToMany(mappedBy="tripPlanner")
	private List<Trippackage> trippackages;

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

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public List<Trippackage> getTrippackages() {
		return this.trippackages;
	}

	public void setTrippackages(List<Trippackage> trippackages) {
		this.trippackages = trippackages;
	}

	public Trippackage addTrippackage(Trippackage trippackage) {
		getTrippackages().add(trippackage);
		trippackage.setTripPlanner(this);

		return trippackage;
	}

	public Trippackage removeTrippackage(Trippackage trippackage) {
		getTrippackages().remove(trippackage);
		trippackage.setTripPlanner(null);

		return trippackage;
	}

}