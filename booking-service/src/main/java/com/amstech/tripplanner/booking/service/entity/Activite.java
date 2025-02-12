package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activites database table.
 * 
 */
@Entity
@Table(name="activites")
@NamedQuery(name="Activite.findAll", query="SELECT a FROM Activite a")
public class Activite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="activity_date")
	private Date activityDate;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Trippackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private Trippackage trippackage;

	//bi-directional many-to-one association to PackageInclude
	@OneToMany(mappedBy="activite")
	private List<PackageInclude> packageIncludes;

	public Activite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getActivityDate() {
		return this.activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Trippackage getTrippackage() {
		return this.trippackage;
	}

	public void setTrippackage(Trippackage trippackage) {
		this.trippackage = trippackage;
	}

	public List<PackageInclude> getPackageIncludes() {
		return this.packageIncludes;
	}

	public void setPackageIncludes(List<PackageInclude> packageIncludes) {
		this.packageIncludes = packageIncludes;
	}

	public PackageInclude addPackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().add(packageInclude);
		packageInclude.setActivite(this);

		return packageInclude;
	}

	public PackageInclude removePackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().remove(packageInclude);
		packageInclude.setActivite(null);

		return packageInclude;
	}

}