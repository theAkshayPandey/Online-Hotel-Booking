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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.proj.spring.crud.helper.HelperClass;
import com.cdac.proj.spring.crud.interfaces.hotelInterface;
import com.cdac.proj.spring.crud.model.AboutHotel;
import com.cdac.proj.spring.crud.model.FilteredData;
import com.cdac.proj.spring.crud.model.HotelInterfaceModel;
import com.cdac.proj.spring.crud.model.Hotelfacility;
import com.cdac.proj.spring.crud.model.Hotelimages;
import com.cdac.proj.spring.crud.model.Reservation;
import com.cdac.proj.spring.crud.model.RoomDetails;
import com.cdac.proj.spring.crud.repository.AboutHotelRepository;
import com.cdac.proj.spring.crud.repository.HotelRepository;
import com.cdac.proj.spring.crud.repository.HotelfacilityRepository;
import com.cdac.proj.spring.crud.repository.HotelimagesRepository;
import com.cdac.proj.spring.crud.repository.ReservationRepository;
import com.cdac.proj.spring.crud.repository.RoomDetailsRepository;
import com.cdac.proj.spring.crud.repository.RoomRepository;

@Service
public class HotelDetailService {

	
	private ReservationRepository reservationrepo;
	private RoomRepository roomrepo;
	private AboutHotelRepository abouthotelrepo;
	private HotelfacilityRepository hotelfacilityrepo;
	private HotelimagesRepository hotelimagerepo;
	private RoomDetailsRepository roomdetailrepo;



	@Autowired
	public void f1( ReservationRepository rrp,RoomRepository rr,
			        AboutHotelRepository aboutrepo,
				    HotelfacilityRepository hfrepo,
				    HotelimagesRepository hotelimg,
				    RoomDetailsRepository roomdetrepo)
	{ 
		System.out.println("autowired successfully");
		reservationrepo = rrp;	
		roomrepo = rr;
		abouthotelrepo= aboutrepo;
		hotelfacilityrepo = hfrepo;
		hotelimagerepo = hotelimg;
		roomdetailrepo = roomdetrepo;
	}

	// function to retrieve all hotel images
	public List<Hotelimages> find_hotel_images_by_hid(int hid)
	{
		
		List<Hotelimages> hotel_img_list = hotelimagerepo.findByHotelid(hid);
		return hotel_img_list;
	}
	
	
	// function to retrieve all hotel facilities
	public List<Hotelfacility> find_hotel_facility_by_hid(int hid)
	{
		List<Hotelfacility> hflist = hotelfacilityrepo.findByHotelid(hid);
		return hflist;
	}
	
	// function to retrieve about hotel details 
	public AboutHotel find_about_hotel_by_hid(int hid)
	{
		AboutHotel abouth = new AboutHotel();
		Optional<AboutHotel> ah = abouthotelrepo.findById(hid);
		if(ah.isPresent())
		{
			abouth=ah.get();
		}
		return abouth;	
	}
	
	
	
	public List<HotelInterfaceModel> find_hotel_detail_by_filtered_data(FilteredData fd)
	{
		int hid = fd.getHotel_id();

		
		
		HelperClass hc = new HelperClass(); 
		HashMap<String, LocalDateTime> dates_dict = hc.convertDateTime(fd.getCheckin(), fd.getCheckout());
		LocalDateTime  checkin = dates_dict.get("checkin");
		LocalDateTime  checkout = dates_dict.get("checkout");
		
		

		List<Reservation> reservation_list =  reservationrepo.findByCheckoutGreaterThanEqualAndCheckinLessThanEqual(checkout, checkin);
		
		List<Integer> room_occupied = new ArrayList<Integer>();
		if ( reservation_list.size() < 1)
		{
			// putting dummy data
			room_occupied = new ArrayList<Integer>(Arrays.asList(0));
		}
		else
		{
			for (int i = 0; i < reservation_list.size(); i++) {
				room_occupied.add((int)reservation_list.get(i).getRoom_id());
			}
		}
		
		
		
		
		// getting the common room and hotel detail
		List<hotelInterface> hotel_detail_list =  roomrepo.get_hotel_detail(hid, room_occupied);
		List<HotelInterfaceModel> hotel_interface_model_list = new ArrayList<HotelInterfaceModel>();
		if (hotel_detail_list.size() == 0)
		{
			return hotel_interface_model_list;
		}
		else
		{
			for (int i = 0; i < hotel_detail_list.size(); i++) {
				HotelInterfaceModel data_model = new HotelInterfaceModel();
				data_model.setHotel_facilities(hotel_detail_list.get(i).getHotel_facilities());
				data_model.setHotel_location(hotel_detail_list.get(i).getHotel_location());
				data_model.setHotel_name(hotel_detail_list.get(i).getHotel_name());
				data_model.setHotel_sub_location(hotel_detail_list.get(i).getHotel_sub_location());
				data_model.setHotel_type(hotel_detail_list.get(i).getHotel_type());
				data_model.setPrice(hotel_detail_list.get(i).getPrice());
				

				data_model.setRoom_id(hotel_detail_list.get(i).getRoom_id());
				
				
				
				// getting room details individually using room_ids 
				int rid = hotel_detail_list.get(i).getRoom_id();
				List<RoomDetails> room_details = roomdetailrepo.findByRoomid(rid);
				data_model.setRoomdetails(room_details);
				
				
				
				
				//room-img
				data_model.setRoom_thumb_img(hotel_detail_list.get(i).getRoom_thumb_img());
				
				
				data_model.setRoom_name(hotel_detail_list.get(i).getRoom_name());
				data_model.setHotel_address(hotel_detail_list.get(i).getAddress());
				data_model.setHotel_rating(hotel_detail_list.get(i).getHotel_rating());
				hotel_interface_model_list.add(data_model);
			}
		}
		return hotel_interface_model_list;
	}
	
	


}


