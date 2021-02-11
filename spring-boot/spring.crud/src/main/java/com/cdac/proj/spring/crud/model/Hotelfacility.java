package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotelfacility {
	@Column(name="id")
	@Id	
	int id;
	
	@Column(name="hotel_id")
	int hotelid;
	
	@Column(name="facility_name")
	String facilityname;
	
	@Column(name="facility_desc")
	String facilitydesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getFacilityname() {
		return facilityname;
	}

	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}

	public String getFacilitydesc() {
		return facilitydesc;
	}

	public void setFacilitydesc(String facilitydesc) {
		this.facilitydesc = facilitydesc;
	}

	public Hotelfacility(int id, int hotelid, String facilityname, String facilitydesc) {
		this.id = id;
		this.hotelid = hotelid;
		this.facilityname = facilityname;
		this.facilitydesc = facilitydesc;
	}

	public Hotelfacility() {
		// TODO Auto-generated constructor stub
	}
	
	
}
