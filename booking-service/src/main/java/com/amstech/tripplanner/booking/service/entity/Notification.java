package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String message;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to PackageInclude
	@ManyToOne
	@JoinColumn(name="package_include_id")
	private PackageInclude packageInclude;

	public Notification() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public PackageInclude getPackageInclude() {
		return this.packageInclude;
	}

	public void setPackageInclude(PackageInclude packageInclude) {
		this.packageInclude = packageInclude;
	}

}