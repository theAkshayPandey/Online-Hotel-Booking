package com.cdac.proj.spring.crud.model;

public class SearchResult {
    String autoComponent;
    String checkin;
    String checkout;
    int guestNo;
    int roomnNo;
	public SearchResult(String autoComponent, String checkin, String checkout, int guestNo, int roomnNo) {
		this.autoComponent = autoComponent;
		this.checkin = checkin;
		this.checkout = checkout;
		this.guestNo = guestNo;
		this.roomnNo = roomnNo;
	}
	
	
	public SearchResult() {
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "SearchResult [autoComponent=" + autoComponent + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", guestNo=" + guestNo + ", roomnNo=" + roomnNo + "]";
	}
	
    
}
