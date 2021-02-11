package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {

	@Column(name="hotel_id")
	@Id
	private int hotelid;
	
	@Column(name="hotel_name")
	private String hotelname;
	

	@Column(name="hotel_location")
	private String hotellocation;
	
	@Column(name="hotel_sub_location")
	private String hotelsublocation;
	
	@Column(name="hotel_facilities")
	private String hotelfacilities;
	
	@Column(name="hotel_rating")
	private String hotelrating;
	
	@Column(name="hotel_type")
	private String hoteltype;
	
	@Column(name="address")
	private String address;
	
	@Column(name="hotel_thumb_image")
	private String hotelthumbimage;

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(int hotelid, String hotelname, String hotellocation, String hotelsublocation, String hotelfacilities,
			String hotelrating, String hoteltype, String address, String hotelthumbimage) {
		super();
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hotellocation = hotellocation;
		this.hotelsublocation = hotelsublocation;
		this.hotelfacilities = hotelfacilities;
		this.hotelrating = hotelrating;
		this.hoteltype = hoteltype;
		this.address = address;
		this.hotelthumbimage = hotelthumbimage;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getHotellocation() {
		return hotellocation;
	}

	public void setHotellocation(String hotellocation) {
		this.hotellocation = hotellocation;
	}

	public String getHotelsublocation() {
		return hotelsublocation;
	}

	public void setHotelsublocation(String hotelsublocation) {
		this.hotelsublocation = hotelsublocation;
	}

	public String getHotelfacilities() {
		return hotelfacilities;
	}

	public void setHotelfacilities(String hotelfacilities) {
		this.hotelfacilities = hotelfacilities;
	}

	public String getHotelrating() {
		return hotelrating;
	}

	public void setHotelrating(String hotelrating) {
		this.hotelrating = hotelrating;
	}

	public String getHoteltype() {
		return hoteltype;
	}

	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHotelthumbimage() {
		return hotelthumbimage;
	}

	public void setHotelthumbimage(String hotelthumbimage) {
		this.hotelthumbimage = hotelthumbimage;
	}

	@Override
	public String toString() {
		return "Hotel [hotelid=" + hotelid + ", hotelname=" + hotelname + ", hotellocation=" + hotellocation
				+ ", hotelsublocation=" + hotelsublocation + ", hotelfacilities=" + hotelfacilities + ", hotelrating="
				+ hotelrating + ", hoteltype=" + hoteltype + ", address=" + address + ", hotelthumbimage="
				+ hotelthumbimage + "]";
	}
	
	
	
	
	
}
