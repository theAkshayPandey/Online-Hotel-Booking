package com.cdac.proj.spring.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.proj.spring.crud.model.BookingDetails;
import com.cdac.proj.spring.crud.model.BookingStatus;
import com.cdac.proj.spring.crud.service.BookingService;

@CrossOrigin(origins="*")
@RestController
public class BookingController {
	
	
	@Autowired
	private BookingService bs;

	
	@PostMapping("/book")
	public BookingStatus bookingintoreservation(@RequestBody BookingDetails bookdet)
	{
		BookingStatus booksts = new BookingStatus();
		booksts = bs.insert_into_reservation(bookdet);
		return booksts;	
	}
}
