package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private int rating;

	private String review;

	@Column(name="trip_detai_id")
	private int tripDetaiId;

	@Column(name="user_id")
	private int userId;

	public Feedback() {
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

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getTripDetaiId() {
		return this.tripDetaiId;
	}

	public void setTripDetaiId(int tripDetaiId) {
		this.tripDetaiId = tripDetaiId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}