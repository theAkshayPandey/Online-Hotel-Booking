package com.cdac.proj.spring.crud.model;

import java.util.List;

public class BookingDetails {


	int totalPrice;
	String roomIdList;
	String address;
	String Country;
	String entryDate;
	String exitDate;
	// no of guest
	int guest;
	String phoneNo;
	int roomNo;
	String state;
	String zipCode;
	String name;
	String email;
	
	
	public BookingDetails() {
		// TODO Auto-generated constructor stub
	}


	public BookingDetails(int totalPrice, String roomIdList, String address, String country, String entryDate,
			String exitDate, int guest, String phoneNo, int roomNo, String state, String zipCode, String name,
			String email) {
		super();
		this.totalPrice = totalPrice;
		this.roomIdList = roomIdList;
		this.address = address;
		Country = country;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.guest = guest;
		this.phoneNo = phoneNo;
		this.roomNo = roomNo;
		this.state = state;
		this.zipCode = zipCode;
		this.name = name;
		this.email = email;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getRoomIdList() {
		return roomIdList;
	}


	public void setRoomIdList(String roomIdList) {
		this.roomIdList = roomIdList;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	public String getExitDate() {
		return exitDate;
	}


	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}


	public int getGuest() {
		return guest;
	}


	public void setGuest(int guest) {
		this.guest = guest;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

	
	
}
