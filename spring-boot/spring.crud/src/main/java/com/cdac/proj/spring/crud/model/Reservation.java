package com.cdac.proj.spring.crud.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Column(name="reservation_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservation_id;
	
	@Column(name="room_id")
	private int room_id;
	
	@Column(name="guest_id")
	private int guest_id;
	
	@Column(name="checkin", columnDefinition = "DATE")
	private LocalDateTime  checkin;
	
	@Column(name="checkout", columnDefinition = "DATE")
	private LocalDateTime  checkout;
	
	@Column(name="booking_id")
	private int bookingid;
	
	public Reservation() {
	}

	public Reservation(int reservation_id, int room_id, int guest_id, LocalDateTime checkin, LocalDateTime checkout,
			int bookingid) {
		super();
		this.reservation_id = reservation_id;
		this.room_id = room_id;
		this.guest_id = guest_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.bookingid = bookingid;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getGuest_id() {
		return guest_id;
	}

	public void setGuest_id(int guest_id) {
		this.guest_id = guest_id;
	}

	public LocalDateTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public LocalDateTime getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDateTime checkout) {
		this.checkout = checkout;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}


	
	
	
}
