package com.cdac.proj.spring.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.proj.spring.crud.service.DashboardService;

@CrossOrigin(origins="*")
@RestController
public class DashboardController {
	
	
	@Autowired
	private DashboardService dashservice;
	
	
	@GetMapping("get-location")
	public List<String> dashboardlocation()
	{
		List<String> list_of_location = new ArrayList<String>();
		list_of_location = dashservice.findLocationFromHotelTable();
		return list_of_location;
	}
	
	
	
}
