package com.cdac.proj.spring.crud.model;

import java.time.LocalDateTime;

public class BookingStatus {

	int insert_status;
	int booking_id;
	int status;
	public BookingStatus() {
		// TODO Auto-generated constructor stub
	}
	public BookingStatus(int insert_status, int booking_id,  int status) {
		super();
		this.insert_status = insert_status;
		this.booking_id = booking_id;

		this.status = status;
	}
	public int getInsert_status() {
		return insert_status;
	}
	public void setInsert_status(int insert_status) {
		this.insert_status = insert_status;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
