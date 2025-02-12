package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the package_include database table.
 * 
 */
@Entity
@Table(name="package_include")
@NamedQuery(name="PackageInclude.findAll", query="SELECT p FROM PackageInclude p")
public class PackageInclude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="packageInclude")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Current
	@OneToMany(mappedBy="packageInclude")
	private List<Current> currents;

	//bi-directional many-to-one association to Discontinue
	@OneToMany(mappedBy="packageInclude")
	private List<Discontinue> discontinues;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="packageInclude")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="packageInclude")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Accommodation
	@ManyToOne
	private Accommodation accommodation;

	//bi-directional many-to-one association to Activite
	@ManyToOne
	@JoinColumn(name="activites_id")
	private Activite activite;

	//bi-directional many-to-one association to Meal
	@ManyToOne
	private Meal meal;

	//bi-directional many-to-one association to PackageImage
	@ManyToOne
	@JoinColumn(name="package_image_id")
	private PackageImage packageImage;

	//bi-directional many-to-one association to Transport
	@ManyToOne
	private Transport transport;

	public PackageInclude() {
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
		booking.setPackageInclude(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPackageInclude(null);

		return booking;
	}

	public List<Current> getCurrents() {
		return this.currents;
	}

	public void setCurrents(List<Current> currents) {
		this.currents = currents;
	}

	public Current addCurrent(Current current) {
		getCurrents().add(current);
		current.setPackageInclude(this);

		return current;
	}

	public Current removeCurrent(Current current) {
		getCurrents().remove(current);
		current.setPackageInclude(null);

		return current;
	}

	public List<Discontinue> getDiscontinues() {
		return this.discontinues;
	}

	public void setDiscontinues(List<Discontinue> discontinues) {
		this.discontinues = discontinues;
	}

	public Discontinue addDiscontinue(Discontinue discontinue) {
		getDiscontinues().add(discontinue);
		discontinue.setPackageInclude(this);

		return discontinue;
	}

	public Discontinue removeDiscontinue(Discontinue discontinue) {
		getDiscontinues().remove(discontinue);
		discontinue.setPackageInclude(null);

		return discontinue;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setPackageInclude(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setPackageInclude(null);

		return feedback;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setPackageInclude(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setPackageInclude(null);

		return notification;
	}

	public Accommodation getAccommodation() {
		return this.accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}

	public Activite getActivite() {
		return this.activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public Meal getMeal() {
		return this.meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public PackageImage getPackageImage() {
		return this.packageImage;
	}

	public void setPackageImage(PackageImage packageImage) {
		this.packageImage = packageImage;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

}