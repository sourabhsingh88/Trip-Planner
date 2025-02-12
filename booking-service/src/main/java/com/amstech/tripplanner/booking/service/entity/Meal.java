package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the meal database table.
 * 
 */
@Entity
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to Trippackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private Trippackage trippackage;

	//bi-directional many-to-one association to PackageInclude
	@OneToMany(mappedBy="meal")
	private List<PackageInclude> packageIncludes;

	public Meal() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		packageInclude.setMeal(this);

		return packageInclude;
	}

	public PackageInclude removePackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().remove(packageInclude);
		packageInclude.setMeal(null);

		return packageInclude;
	}

}