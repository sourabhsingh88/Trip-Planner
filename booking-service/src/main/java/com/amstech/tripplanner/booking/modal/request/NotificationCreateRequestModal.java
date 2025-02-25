package com.amstech.tripplanner.booking.modal.request;

public class NotificationCreateRequestModal {

	private int  userId;
	private int tripDetailId;
	private String tital;
	private String message;
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
	public String getTital() {
		return tital;
	}
	public void setTital(String tital) {
		this.tital = tital;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
