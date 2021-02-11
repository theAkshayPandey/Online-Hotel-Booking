package com.cdac.proj.spring.crud.model;

import java.util.List;

public class HotelInterfaceModel {

	String hotel_name;
	String hotel_location;
	String hotel_sub_location;
	String hotel_facilities;
	String hotel_type;
	String room_name;
	String hotel_address;
	String hotel_rating;
	int price;
	int room_id;
	String room_thumb_img;
	List<RoomDetails> roomdetails;
	public HotelInterfaceModel(String hotel_name, String hotel_location, String hotel_sub_location,
			String hotel_facilities, String hotel_type, String room_name, String hotel_address, String hotel_rating,
			int price, int room_id, String room_thumb_img, List<RoomDetails> roomdetails) {
		this.hotel_name = hotel_name;
		this.hotel_location = hotel_location;
		this.hotel_sub_location = hotel_sub_location;
		this.hotel_facilities = hotel_facilities;
		this.hotel_type = hotel_type;
		this.room_name = room_name;
		this.hotel_address = hotel_address;
		this.hotel_rating = hotel_rating;
		this.price = price;
		this.room_id = room_id;
		this.room_thumb_img = room_thumb_img;
		this.roomdetails = roomdetails;
	}
	public HotelInterfaceModel() {
		// TODO Auto-generated constructor stub
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_location() {
		return hotel_location;
	}
	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}
	public String getHotel_sub_location() {
		return hotel_sub_location;
	}
	public void setHotel_sub_location(String hotel_sub_location) {
		this.hotel_sub_location = hotel_sub_location;
	}
	public String getHotel_facilities() {
		return hotel_facilities;
	}
	public void setHotel_facilities(String hotel_facilities) {
		this.hotel_facilities = hotel_facilities;
	}
	public String getHotel_type() {
		return hotel_type;
	}
	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_rating() {
		return hotel_rating;
	}
	public void setHotel_rating(String hotel_rating) {
		this.hotel_rating = hotel_rating;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_thumb_img() {
		return room_thumb_img;
	}
	public void setRoom_thumb_img(String room_thumb_img) {
		this.room_thumb_img = room_thumb_img;
	}
	public List<RoomDetails> getRoomdetails() {
		return roomdetails;
	}
	public void setRoomdetails(List<RoomDetails> roomdetails) {
		this.roomdetails = roomdetails;
	}
	@Override
	public String toString() {
		return "HotelInterfaceModel [hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_sub_location=" + hotel_sub_location + ", hotel_facilities=" + hotel_facilities
				+ ", hotel_type=" + hotel_type + ", room_name=" + room_name + ", hotel_address=" + hotel_address
				+ ", hotel_rating=" + hotel_rating + ", price=" + price + ", room_id=" + room_id + ", room_thumb_img="
				+ room_thumb_img + ", roomdetails=" + roomdetails + "]";
	}
	

	

	
	
	
}
