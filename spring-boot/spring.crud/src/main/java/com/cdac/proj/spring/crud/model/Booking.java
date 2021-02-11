package com.cdac.proj.spring.crud.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	
	@Column(name = "booking_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingid ;
    
	@Column(name = "guest_id")
	private int guest_id;
        
	@Column(name = "booking_status")
	private int bookingstatus;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(Integer bookingid, int guest_id, int bookingstatus) {
		super();
		this.bookingid = bookingid;
		this.guest_id = guest_id;
		this.bookingstatus = bookingstatus;
	}

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public int getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(int bookingstatus) {
		this.bookingstatus = bookingstatus;
	}



}
