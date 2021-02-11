package com.cdac.proj.spring.crud.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.proj.spring.crud.helper.HelperClass;
import com.cdac.proj.spring.crud.interfaces.HotelAvailableInterface;
import com.cdac.proj.spring.crud.interfaces.HotelWithRoomDataInterface;
import com.cdac.proj.spring.crud.model.HotelDetailWithRoom;
import com.cdac.proj.spring.crud.model.Reservation;
import com.cdac.proj.spring.crud.model.SearchResult;
import com.cdac.proj.spring.crud.repository.HotelRepository;
import com.cdac.proj.spring.crud.repository.ReservationRepository;
import com.cdac.proj.spring.crud.repository.RoomRepository;


@Service
public class HotelListingService {

	
	private ReservationRepository reservationrepo;
	private RoomRepository roomrepo;
	private HotelRepository hotelrepo;
	
	@Autowired
	public void initialize_repository( ReservationRepository rr,
									   RoomRepository rmp,
									   HotelRepository hr
									 )
	{
		reservationrepo = rr;
		roomrepo = rmp;
		hotelrepo = hr;
	}
	
	
	
	public List<HotelDetailWithRoom> getHotelDetailWithRoom(SearchResult sr)
	{
	
		HelperClass hc = new HelperClass(); 
		HashMap<String, LocalDateTime> dates_dict = hc.convertDateTime(sr.getCheckin(), sr.getCheckout());
		
		
		LocalDateTime  checkin = dates_dict.get("checkin");
		LocalDateTime  checkout = dates_dict.get("checkout");

	
		
//		List<Reservation> reservation_list =  reservationrepo.findByCheckoutGreaterThanEqualAndCheckinLessThanEqual(checkout, checkin);
		List<Reservation> reservation_list = reservationrepo.findByCheckoutLessThanEqualAndCheckinGreaterThanEqual(checkout, checkin);
		

		
		List<Integer> room_occupied = new ArrayList<Integer>();
		if ( reservation_list.size() < 1)
		{
			// putting dummy data
			room_occupied = new ArrayList<Integer>(Arrays.asList(0));
		}
		else
		{
			for (int i = 0; i < reservation_list.size(); i++) {
				room_occupied.add( (int ) reservation_list.get(i).getRoom_id()  );
			}
		}
		
		
		// remove this
//		int capacity_needed = sr.getGuestNo();
		
		int capacity_needed = sr.getRoomnNo();
		
		List<HotelAvailableInterface> hotel_available = roomrepo.get_hotel_available_to_interface(room_occupied, capacity_needed);
		
		
		List<Integer> hotel_id_list = new ArrayList<Integer>();
		for (int i = 0; i < hotel_available.size(); i++) {
			hotel_id_list.add(hotel_available.get(i).getHotel_id());
		}
		
		String location = sr.getAutoComponent();
		
		
		
		List<HotelWithRoomDataInterface> final_hotel_detail = hotelrepo.get_filtered_data(room_occupied,hotel_id_list,location);
		
		
		
		List<HotelDetailWithRoom> hotel_list =  new ArrayList<HotelDetailWithRoom>();
		
		for (int i = 0; i < final_hotel_detail.size(); i++) {
			HotelDetailWithRoom temp = new HotelDetailWithRoom();
			
			
			int hotel_id = final_hotel_detail.get(i).getHotel_id();
			String hotel_name = final_hotel_detail.get(i).getHotel_name();
			String sub_location = final_hotel_detail.get(i).getHotel_sub_location();
			String hotel_facilities = final_hotel_detail.get(i).getHotel_facilities();
			String rating = final_hotel_detail.get(i).getHotel_rating();
			int room_price = final_hotel_detail.get(i).getMinprice();
			int room_id = final_hotel_detail.get(i).getRoom_id();
			String hotel_type = final_hotel_detail.get(i).getHotel_type();
			String hotel_address = final_hotel_detail.get(i).getAddress();
			String hotel_thumb_img = final_hotel_detail.get(i).getHotel_thumb_image();
			
			
			temp.setHotel_id(hotel_id);
			temp.setHotel_name(hotel_name);
			temp.setSub_location(sub_location);
			temp.setFacility(hotel_facilities);
			temp.setHotel_rating(rating);
			temp.setRoom_price(room_price);
			temp.setRoom_id(room_id);
			temp.setHotel_type(hotel_type);
			temp.setAddress(hotel_address);
			temp.setHotel_thumb_image(hotel_thumb_img);
			
			hotel_list.add(temp);
			
		}
		return hotel_list;

	}
}
