package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the history database table.
 * 
 */
@Entity
@NamedQuery(name="History.findAll", query="SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_at")
	private String createdAt;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="bookings_id")
	private Booking booking;

	public History() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}