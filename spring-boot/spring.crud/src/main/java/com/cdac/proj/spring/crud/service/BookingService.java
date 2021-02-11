package com.cdac.proj.spring.crud.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cdac.proj.spring.crud.helper.HelperClass;
import com.cdac.proj.spring.crud.model.Booking;
import com.cdac.proj.spring.crud.model.BookingDetails;
import com.cdac.proj.spring.crud.model.BookingStatus;
import com.cdac.proj.spring.crud.model.Guest;
import com.cdac.proj.spring.crud.model.Hotelimages;
import com.cdac.proj.spring.crud.model.Reservation;
import com.cdac.proj.spring.crud.repository.BookingRepository;
import com.cdac.proj.spring.crud.repository.GuestRepository;
import com.cdac.proj.spring.crud.repository.ReservationRepository;


@Service
public class BookingService {

	
	private ReservationRepository reservationrepo;
	private GuestRepository guestrepo;
	private BookingRepository bookrepo;
	
	@Autowired
	public void f1( ReservationRepository rrp,GuestRepository gr,BookingRepository br)
	{ 
		System.out.println("autowired successfully");
		reservationrepo = rrp;	
		guestrepo = gr;
		bookrepo = br;
	}
	
	
	
	public BookingStatus insert_into_reservation(BookingDetails bookdet)
	{
		BookingStatus booksts = new BookingStatus();
		
		
		int insert_status = 0;
				
		List<Reservation> reslist = new ArrayList<Reservation>();
		
		String rlist = bookdet.getRoomIdList();
		
		
		
		HelperClass hc = new HelperClass(); 
		HashMap<String, LocalDateTime> dates_dict = hc.convertDateTime(bookdet.getEntryDate(), bookdet.getExitDate());
		LocalDateTime  checkin = dates_dict.get("checkin");
		LocalDateTime  checkout = dates_dict.get("checkout");
		
		
		
		System.out.println("checkin :" + checkin);
		System.out.println("checout :" + checkout);
		

		// make new guest every time
		Guest guest = new Guest();
		guest.setAddress(bookdet.getAddress());
		guest.setCountry(bookdet.getCountry());
		guest.setMobileno(bookdet.getPhoneNo());
		guest.setName(bookdet.getName());
		guest.setState(bookdet.getState());
		guest.setZipcode(bookdet.getZipCode());
		
		int guest_id = 0; 
		
		
		try {
			guestrepo.save(guest);
			guest_id = guest.getGuestid();
		} catch (Exception e) {
			System.out.println("Cannot Insert Guest" + e);
		}
		
		if (guest_id != 0 )
		{
			
			
			Booking bkng = new Booking();
			bkng.setGuest_id(guest_id);
			bookrepo.save(bkng);			
			
			
			
			
			int bookingid = bkng.getBookingid();
			
			System.out.println("bookingid : "+ bookingid);
			
			
			
			String[] room_list = rlist.split(",");
			int length = room_list.length;
			
			
			for (int i = 0; i < length; i++) {
				Reservation rs = new Reservation();
				int room_id = Integer.parseInt(room_list[i]);
				rs.setCheckin(checkin);
				rs.setCheckout(checkout);
				rs.setGuest_id(guest_id);
				rs.setRoom_id(room_id);
				rs.setBookingid(bookingid);
				reslist.add(rs);
			}
			
			
			int bulk_status = 0;
			
			
			try {
				reservationrepo.saveAll(reslist);
				bulk_status = 1;
				bkng.setBookingstatus(1);
				
				bookrepo.save(bkng);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			insert_status = bulk_status;
			
			
			
			
			booksts.setBooking_id(bookingid);
			booksts.setInsert_status(bulk_status);
			booksts.setStatus(bkng.getBookingstatus());
			
			
		}
		

		
		return booksts;
		
	}
}