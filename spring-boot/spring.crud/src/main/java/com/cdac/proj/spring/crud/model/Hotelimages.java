package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="hotelimages")
@Entity
public class Hotelimages {

	@Id
	int id;
	
	@Column(name="hotel_id")
	int hotelid;

	@Column(name="image_path")
	String imagepath;

	public Hotelimages() {
		// TODO Auto-generated constructor stub
	}

	public Hotelimages(int id, int hotelid, String imagepath) {
		this.id = id;
		this.hotelid = hotelid;
		this.imagepath = imagepath;
	}

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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
	
	
}
