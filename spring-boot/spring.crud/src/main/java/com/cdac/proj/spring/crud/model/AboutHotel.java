package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "abouthotel")
public class AboutHotel {

	@Column(name="id")
	@Id
	int id;
	
	@Column(name="hotel_id")
	int hotelid;
	
	@Column(name="description")
	String description;

	@Column(name="checkin_time")
	String checkintime;
	
	@Column(name="checkout_time")	
	String checkoutime;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}

	public String getCheckoutime() {
		return checkoutime;
	}

	public void setCheckoutime(String checkoutime) {
		this.checkoutime = checkoutime;
	}

	public AboutHotel(int id, int hotelid, String description, String checkintime, String checkoutime) {
		this.id = id;
		this.hotelid = hotelid;
		this.description = description;
		this.checkintime = checkintime;
		this.checkoutime = checkoutime;
	}

	public AboutHotel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AboutHotel [id=" + id + ", hotelid=" + hotelid + ", description=" + description + ", checkintime="
				+ checkintime + ", checkoutime=" + checkoutime + "]";
	}
	

	
	
	
}
