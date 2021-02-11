package com.cdac.proj.spring.crud.model;

public class HotelDetailWithRoom {
	
	int hotel_id;
	String hotel_name;
	String sub_location;
	String facility;
	int room_id;
	String hotel_rating;
	int room_price;
	String hotel_type;
	String address;
	String  hotel_thumb_image;
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getSub_location() {
		return sub_location;
	}
	public void setSub_location(String sub_location) {
		this.sub_location = sub_location;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getHotel_rating() {
		return hotel_rating;
	}
	public void setHotel_rating(String hotel_rating) {
		this.hotel_rating = hotel_rating;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getHotel_type() {
		return hotel_type;
	}
	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHotel_thumb_image() {
		return hotel_thumb_image;
	}
	public void setHotel_thumb_image(String hotel_thumb_image) {
		this.hotel_thumb_image = hotel_thumb_image;
	}
	public HotelDetailWithRoom(int hotel_id, String hotel_name, String sub_location, String facility, int room_id,
			String hotel_rating, int room_price, String hotel_type, String address, String hotel_thumb_image) {
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.sub_location = sub_location;
		this.facility = facility;
		this.room_id = room_id;
		this.hotel_rating = hotel_rating;
		this.room_price = room_price;
		this.hotel_type = hotel_type;
		this.address = address;
		this.hotel_thumb_image = hotel_thumb_image;
	}
	public HotelDetailWithRoom() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
}
