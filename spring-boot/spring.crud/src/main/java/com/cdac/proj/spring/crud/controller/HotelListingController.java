package com.cdac.proj.spring.crud.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.proj.spring.crud.model.HotelDetailWithRoom;
import com.cdac.proj.spring.crud.model.Reservation;
import com.cdac.proj.spring.crud.model.SearchResult;
import com.cdac.proj.spring.crud.service.HotelListingService;



@CrossOrigin(origins="*")
@RestController
public class HotelListingController {

	
	@Autowired
	private HotelListingService hlservice;
	
	
	@PostMapping("/get-hotel-list")
	public List<HotelDetailWithRoom>  cat(@RequestBody SearchResult sr)
	{
		List<HotelDetailWithRoom> hotel_list =  new ArrayList<HotelDetailWithRoom>();
		hotel_list = hlservice.getHotelDetailWithRoom(sr);
		return hotel_list;
	}
	
	
}
