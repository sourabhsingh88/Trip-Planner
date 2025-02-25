package com.amstech.tripplanner.booking.modal.response;

import java.util.Date;

public class NotificationResponseModal {
	private int id;
	private int userId;
	private int tripDetailId;
	private String title;
	private String message;
	private Date createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTripDetailId() {
		return tripDetailId;
	}
	public void setTripDetailId(int tripDetailId) {
		this.tripDetailId = tripDetailId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
