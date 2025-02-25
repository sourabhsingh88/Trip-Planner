package com.amstech.tripplanner.booking.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bookings database table.
 * 
 */
@Entity
@Table(name="bookings")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="book_at")
	private Date bookAt;

	@Column(name="img_url")
	private String imgUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to Status
	@ManyToOne
	private Status status;

	//bi-directional many-to-one association to TripDetail
	@ManyToOne
	@JoinColumn(name="trip_detail_id")
	private TripDetail tripDetail;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="booking")
	private List<History> histories;

	public Booking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBookAt() {
		return this.bookAt;
	}

	public void setBookAt(Date bookAt) {
		this.bookAt = bookAt;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TripDetail getTripDetail() {
		return this.tripDetail;
	}

	public void setTripDetail(TripDetail tripDetail) {
		this.tripDetail = tripDetail;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setBooking(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setBooking(null);

		return history;
	}

}