package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
@Table(name="guest")
@Entity
public class Guest {

	@Column(name="guest_id")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  guestid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile_no")
	private String mobileno;
	
	@Column(name="address")
	private String address;
	
	@Column(name="country")
	private String country; 
	
	@Column(name="state")
	private String state; 
	
	@Column(name="zipcode")
	private String zipcode;
	
	public Guest() {
	}

	public Guest(Integer  guestid, String name, String mobileno, String address, String country, String state,
			String zipcode) {
		super();
		this.guestid = guestid;
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.country = country;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Integer  getGuestid() {
		return guestid;
	}

	public void setGuestid(Integer  guestid) {
		this.guestid = guestid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	} 
	
	
	
}
