package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the accommodation database table.
 * 
 */
@Entity
@NamedQuery(name="Accommodation.findAll", query="SELECT a FROM Accommodation a")
public class Accommodation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int capacity;

	@Column(name="contect_number")
	private String contectNumber;

	@Lob
	private String description;

	private String email;

	private String name;

	private String types;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Trippackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private Trippackage trippackage;

	//bi-directional many-to-one association to PackageInclude
	@OneToMany(mappedBy="accommodation")
	private List<PackageInclude> packageIncludes;

	public Accommodation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getContectNumber() {
		return this.contectNumber;
	}

	public void setContectNumber(String contectNumber) {
		this.contectNumber = contectNumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypes() {
		return this.types;
	}

	public void setTypes(String types) {
		this.types = types;
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
		packageInclude.setAccommodation(this);

		return packageInclude;
	}

	public PackageInclude removePackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().remove(packageInclude);
		packageInclude.setAccommodation(null);

		return packageInclude;
	}

}