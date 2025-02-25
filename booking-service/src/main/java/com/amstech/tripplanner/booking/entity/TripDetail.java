package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the trip_detail database table.
 * 
 */
@Entity
@Table(name="trip_detail")
@NamedQuery(name="TripDetail.findAll", query="SELECT t FROM TripDetail t")
public class TripDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="tripDetail")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="tripDetail")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Accommodation
	@ManyToOne
	private Accommodation accommodation;

	//bi-directional many-to-one association to Meal
	@ManyToOne
	private Meal meal;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	//bi-directional many-to-one association to Transport
	@ManyToOne
	private Transport transport;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	private Trip trip;

	//bi-directional many-to-one association to TripBanner
	@ManyToOne
	@JoinColumn(name="trip_banner_id")
	private TripBanner tripBanner;

	//bi-directional many-to-one association to TripPlanner
	@ManyToOne
	@JoinColumn(name="trip_planner_id")
	private TripPlanner tripPlanner;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	private Activity activity;

	public TripDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setTripDetail(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setTripDetail(null);

		return booking;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setTripDetail(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setTripDetail(null);

		return notification;
	}

	public Accommodation getAccommodation() {
		return this.accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public TripBanner getTripBanner() {
		return this.tripBanner;
	}

	public void setTripBanner(TripBanner tripBanner) {
		this.tripBanner = tripBanner;
	}

	public TripPlanner getTripPlanner() {
		return this.tripPlanner;
	}

	public void setTripPlanner(TripPlanner tripPlanner) {
		this.tripPlanner = tripPlanner;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}