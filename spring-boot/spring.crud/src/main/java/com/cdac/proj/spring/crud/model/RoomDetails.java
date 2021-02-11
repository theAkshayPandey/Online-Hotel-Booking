package com.cdac.proj.spring.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="roomdetails")
@Entity
public class RoomDetails {

	@Id
	int id; 
	
	@Column(name="room_id")
	int roomid;

	@Column(name="room_features")
	String roomfeatures;

	public RoomDetails(int id, int roomid, String roomfeatures) {
		this.id = id;
		this.roomid = roomid;
		this.roomfeatures = roomfeatures;
	}

	public RoomDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getRoomfeatures() {
		return roomfeatures;
	}

	public void setRoomfeatures(String roomfeatures) {
		this.roomfeatures = roomfeatures;
	}

	

}
