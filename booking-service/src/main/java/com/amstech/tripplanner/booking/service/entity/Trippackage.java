package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trippackage database table.
 * 
 */
@Entity
@NamedQuery(name="Trippackage.findAll", query="SELECT t FROM Trippackage t")
public class Trippackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Lob
	private String description;

	private int duration;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private String from;

	private String name;

	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	private String to;

	@Column(name="tour_guide_name")
	private String tourGuideName;

	//bi-directional many-to-one association to Accommodation
	@OneToMany(mappedBy="trippackage")
	private List<Accommodation> accommodations;

	//bi-directional many-to-one association to Activite
	@OneToMany(mappedBy="trippackage")
	private List<Activite> activites;

	//bi-directional many-to-one association to Meal
	@OneToMany(mappedBy="trippackage")
	private List<Meal> meals;

	//bi-directional many-to-one association to PackageImage
	@OneToMany(mappedBy="trippackage")
	private List<PackageImage> packageImages;

	//bi-directional many-to-one association to Transport
	@OneToMany(mappedBy="trippackage")
	private List<Transport> transports;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to TripPlanner
	@ManyToOne
	@JoinColumn(name="trip_planner_id")
	private TripPlanner tripPlanner;

	public Trippackage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTourGuideName() {
		return this.tourGuideName;
	}

	public void setTourGuideName(String tourGuideName) {
		this.tourGuideName = tourGuideName;
	}

	public List<Accommodation> getAccommodations() {
		return this.accommodations;
	}

	public void setAccommodations(List<Accommodation> accommodations) {
		this.accommodations = accommodations;
	}

	public Accommodation addAccommodation(Accommodation accommodation) {
		getAccommodations().add(accommodation);
		accommodation.setTrippackage(this);

		return accommodation;
	}

	public Accommodation removeAccommodation(Accommodation accommodation) {
		getAccommodations().remove(accommodation);
		accommodation.setTrippackage(null);

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
		activite.setTrippackage(this);

		return activite;
	}

	public Activite removeActivite(Activite activite) {
		getActivites().remove(activite);
		activite.setTrippackage(null);

		return activite;
	}

	public List<Meal> getMeals() {
		return this.meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Meal addMeal(Meal meal) {
		getMeals().add(meal);
		meal.setTrippackage(this);

		return meal;
	}

	public Meal removeMeal(Meal meal) {
		getMeals().remove(meal);
		meal.setTrippackage(null);

		return meal;
	}

	public List<PackageImage> getPackageImages() {
		return this.packageImages;
	}

	public void setPackageImages(List<PackageImage> packageImages) {
		this.packageImages = packageImages;
	}

	public PackageImage addPackageImage(PackageImage packageImage) {
		getPackageImages().add(packageImage);
		packageImage.setTrippackage(this);

		return packageImage;
	}

	public PackageImage removePackageImage(PackageImage packageImage) {
		getPackageImages().remove(packageImage);
		packageImage.setTrippackage(null);

		return packageImage;
	}

	public List<Transport> getTransports() {
		return this.transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}

	public Transport addTransport(Transport transport) {
		getTransports().add(transport);
		transport.setTrippackage(this);

		return transport;
	}

	public Transport removeTransport(Transport transport) {
		getTransports().remove(transport);
		transport.setTrippackage(null);

		return transport;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public TripPlanner getTripPlanner() {
		return this.tripPlanner;
	}

	public void setTripPlanner(TripPlanner tripPlanner) {
		this.tripPlanner = tripPlanner;
	}

}