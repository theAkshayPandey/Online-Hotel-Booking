package com.cdac.proj.spring.crud.model;

public class FilteredData {

	
    String autoComponent;
    String checkin;
    String checkout;
    int guestNo;
    int roomnNo;
    int room_id;
    int hotel_id;
	public FilteredData(String autoComponent, String checkin, String checkout, int guestNo, int roomnNo, int room_id,
			int hotel_id) {
		this.autoComponent = autoComponent;
		this.checkin = checkin;
		this.checkout = checkout;
		this.guestNo = guestNo;
		this.roomnNo = roomnNo;
		this.room_id = room_id;
		this.hotel_id = hotel_id;
	}
	public String getAutoComponent() {
		return autoComponent;
	}
	public void setAutoComponent(String autoComponent) {
		this.autoComponent = autoComponent;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public int getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}
	public int getRoomnNo() {
		return roomnNo;
	}
	public void setRoomnNo(int roomnNo) {
		this.roomnNo = roomnNo;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	@Override
	public String toString() {
		return "FilteredData [autoComponent=" + autoComponent + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", guestNo=" + guestNo + ", roomnNo=" + roomnNo + ", room_id=" + room_id + ", hotel_id=" + hotel_id
				+ "]";
	}
    
	
    
    
}
