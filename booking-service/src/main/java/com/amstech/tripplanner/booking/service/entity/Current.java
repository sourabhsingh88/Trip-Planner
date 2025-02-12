package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the current database table.
 * 
 */
@Entity
@NamedQuery(name="Current.findAll", query="SELECT c FROM Current c")
public class Current implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to PackageInclude
	@ManyToOne
	@JoinColumn(name="package_include_id")
	private PackageInclude packageInclude;

	public Current() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PackageInclude getPackageInclude() {
		return this.packageInclude;
	}

	public void setPackageInclude(PackageInclude packageInclude) {
		this.packageInclude = packageInclude;
	}

}