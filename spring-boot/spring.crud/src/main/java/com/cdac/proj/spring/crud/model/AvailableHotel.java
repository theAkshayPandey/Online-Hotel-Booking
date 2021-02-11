package com.cdac.proj.spring.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;




public class AvailableHotel {


	int hotel_id;
	int total_room;
	int total_capacity;
	
	public AvailableHotel(int hotel_id, int total_room, int total_capacity) {
		this.hotel_id = hotel_id;
		this.total_room = total_room;
		this.total_capacity = total_capacity;
	}
	
	public AvailableHotel() {
		// TODO Auto-generated constructor stub
	}

	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getTotal_room() {
		return total_room;
	}
	public void setTotal_room(int total_room) {
		this.total_room = total_room;
	}
	public int getTotal_capacity() {
		return total_capacity;
	}
	public void setTotal_capacity(int total_capacity) {
		this.total_capacity = total_capacity;
	}

	@Override
	public String toString() {
		return "AvailableHotel [hotel_id=" + hotel_id + ", total_room=" + total_room + ", total_capacity="
				+ total_capacity + "]";
	}


	
	
	
}
