package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Accommodation
	@OneToMany(mappedBy="location")
	private List<Accommodation> accommodations;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="location")
	private List<Activite> activites;

	//bi-directional many-to-one association to City
	@ManyToOne
	private City city;

	//bi-directional many-to-one association to Trippackage
	@OneToMany(mappedBy="location")
	private List<Trippackage> trippackages;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="location")
	private List<User> users;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Accommodation> getAccommodations() {
		return this.accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public Accommodation addAccommodation(Accommodation accommodation) {
		getAccommodations().add(accommodation);
		accommodation.setLocation(this);

		return accommodation;
	}

	public Accommodation removeAccommodation(Accommodation accommodation) {
		getAccommodations().remove(accommodation);
		accommodation.setLocation(null);

		return accommodation;
	}

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Activite addActivite(Activite activite) {
		getActivites().add(activite);
		activite.setLocation(this);

		return activite;
	}

	public Activite removeActivite(Activite activite) {
		getActivites().remove(activite);
		activite.setLocation(null);

		return activite;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Trippackage> getTrippackages() {
		return this.trippackages;
	}

	public void setTrippackages(List<Trippackage> trippackages) {
		this.trippackages = trippackages;
	}

	public Trippackage addTrippackage(Trippackage trippackage) {
		getTrippackages().add(trippackage);
		trippackage.setLocation(this);

		return trippackage;
	}

	public Trippackage removeTrippackage(Trippackage trippackage) {
		getTrippackages().remove(trippackage);
		trippackage.setLocation(null);

		return trippackage;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLocation(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLocation(null);

		return user;
	}

}