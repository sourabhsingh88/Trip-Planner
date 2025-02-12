package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@NamedQuery(name="Transport.findAll", query="SELECT t FROM Transport t")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	@Column(name="drop_time")
	private Time dropTime;

	private String name;

	@Column(name="pikup_time")
	private Time pikupTime;

	//bi-directional many-to-one association to PackageInclude
	@OneToMany(mappedBy="transport")
	private List<PackageInclude> packageIncludes;

	//bi-directional many-to-one association to Trippackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private Trippackage trippackage;

	public Transport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getDropTime() {
		return this.dropTime;
	}

	public void setDropTime(Time dropTime) {
		this.dropTime = dropTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getPikupTime() {
		return this.pikupTime;
	}

	public void setPikupTime(Time pikupTime) {
		this.pikupTime = pikupTime;
	}

	public List<PackageInclude> getPackageIncludes() {
		return this.packageIncludes;
	}

	public void setPackageIncludes(List<PackageInclude> packageIncludes) {
		this.packageIncludes = packageIncludes;
	}

	public PackageInclude addPackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().add(packageInclude);
		packageInclude.setTransport(this);

		return packageInclude;
	}

	public PackageInclude removePackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().remove(packageInclude);
		packageInclude.setTransport(null);

		return packageInclude;
	}

	public Trippackage getTrippackage() {
		return this.trippackage;
	}

	public void setTrippackage(Trippackage trippackage) {
		this.trippackage = trippackage;
	}

}