package com.amstech.tripplanner.booking.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the package_image database table.
 * 
 */
@Entity
@Table(name="package_image")
@NamedQuery(name="PackageImage.findAll", query="SELECT p FROM PackageImage p")
public class PackageImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="background_url_1")
	private String backgroundUrl1;

	@Column(name="banner_url_1")
	private String bannerUrl1;

	@Column(name="banner_url_2")
	private String bannerUrl2;

	@Column(name="banner_url_3")
	private String bannerUrl3;

	private String description;

	//bi-directional many-to-one association to Trippackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private Trippackage trippackage;

	//bi-directional many-to-one association to PackageInclude
	@OneToMany(mappedBy="packageImage")
	private List<PackageInclude> packageIncludes;

	public PackageImage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBackgroundUrl1() {
		return this.backgroundUrl1;
	}

	public void setBackgroundUrl1(String backgroundUrl1) {
		this.backgroundUrl1 = backgroundUrl1;
	}

	public String getBannerUrl1() {
		return this.bannerUrl1;
	}

	public void setBannerUrl1(String bannerUrl1) {
		this.bannerUrl1 = bannerUrl1;
	}

	public String getBannerUrl2() {
		return this.bannerUrl2;
	}

	public void setBannerUrl2(String bannerUrl2) {
		this.bannerUrl2 = bannerUrl2;
	}

	public String getBannerUrl3() {
		return this.bannerUrl3;
	}

	public void setBannerUrl3(String bannerUrl3) {
		this.bannerUrl3 = bannerUrl3;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		packageInclude.setPackageImage(this);

		return packageInclude;
	}

	public PackageInclude removePackageInclude(PackageInclude packageInclude) {
		getPackageIncludes().remove(packageInclude);
		packageInclude.setPackageImage(null);

		return packageInclude;
	}

}