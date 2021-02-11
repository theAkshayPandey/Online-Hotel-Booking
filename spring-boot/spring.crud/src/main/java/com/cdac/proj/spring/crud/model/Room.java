package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
	
	
	@Column(name="room_id")
	@Id
	private int roomid;
	
	@Column(name="hotel_id")
	int hotelid;
	
	@Column(name="capacity")
	int capacity;
	
	@Column(name="room_name")
	String roomname;
	
	@Column(name="room_thumb_img")	
	String roomthumbimg;

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getRoomthumbimg() {
		return roomthumbimg;
	}

	public void setRoomthumbimg(String roomthumbimg) {
		this.roomthumbimg = roomthumbimg;
	}

	public Room(int roomid, int hotelid, int capacity, String roomname, String roomthumbimg) {
		this.roomid = roomid;
		this.hotelid = hotelid;
		this.capacity = capacity;
		this.roomname = roomname;
		this.roomthumbimg = roomthumbimg;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
