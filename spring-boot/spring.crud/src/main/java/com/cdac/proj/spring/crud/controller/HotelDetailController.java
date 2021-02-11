package com.cdac.proj.spring.crud.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.proj.spring.crud.model.SearchResult;
import com.cdac.proj.spring.crud.interfaces.hotelInterface;
import com.cdac.proj.spring.crud.model.AboutHotel;
import com.cdac.proj.spring.crud.model.AvailableHotel;
import com.cdac.proj.spring.crud.model.FilteredData;
import com.cdac.proj.spring.crud.model.Hotel;
import com.cdac.proj.spring.crud.model.HotelDetailWithRoom;
import com.cdac.proj.spring.crud.model.HotelInterfaceModel;
import com.cdac.proj.spring.crud.model.Hotelfacility;
import com.cdac.proj.spring.crud.model.Hotelimages;
import com.cdac.proj.spring.crud.model.Reservation;
import com.cdac.proj.spring.crud.model.Room;
import com.cdac.proj.spring.crud.model.RoomDetails;
import com.cdac.proj.spring.crud.repository.AboutHotelRepository;
import com.cdac.proj.spring.crud.repository.HotelRepository;
import com.cdac.proj.spring.crud.repository.HotelfacilityRepository;
import com.cdac.proj.spring.crud.repository.HotelimagesRepository;
import com.cdac.proj.spring.crud.repository.ReservationRepository;
import com.cdac.proj.spring.crud.repository.RoomDetailsRepository;
import com.cdac.proj.spring.crud.repository.RoomRepository;
import com.cdac.proj.spring.crud.service.HotelDetailService;



@CrossOrigin(origins="*")
@RestController
public class HotelDetailController {

	@Autowired
	private HotelDetailService hotel_detail_service;
	
	@GetMapping("/images-hotel")
	public List<Hotelimages> getHotelImage(@RequestParam int id)
	{
		List<Hotelimages> hotel_img_list = new ArrayList<Hotelimages>();
		hotel_img_list = hotel_detail_service.find_hotel_images_by_hid(id);
		return hotel_img_list;
	}
	
	
	@GetMapping("/facility-hotel")
	public List<Hotelfacility> getHotelFacility(@RequestParam int id)
	{
		List<Hotelfacility> hotel_facility_list = new ArrayList<Hotelfacility>();
		hotel_facility_list = hotel_detail_service.find_hotel_facility_by_hid(id);
		return hotel_facility_list;
	}
	

	@GetMapping("/about-hotel")
	public AboutHotel getAboutHotel(@RequestParam int id)
	{
		AboutHotel abouth = new AboutHotel();
		abouth = hotel_detail_service.find_about_hotel_by_hid(id);
		return abouth;
	}
	
	
	@PostMapping("/hotel-detail")
	public List<HotelInterfaceModel> getHotelDetail(@RequestBody FilteredData fd)
	{
		List<HotelInterfaceModel> hotel_interface_model_list = new ArrayList<HotelInterfaceModel>();
		hotel_interface_model_list = hotel_detail_service.find_hotel_detail_by_filtered_data(fd);
		return hotel_interface_model_list;
	}

}
