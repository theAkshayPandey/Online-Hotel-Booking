package com.cdac.proj.spring.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.proj.spring.crud.model.Hotel;
import com.cdac.proj.spring.crud.repository.HotelRepository;

@Service
public class DashboardService {

	
	private HotelRepository hotelrepo;
	
	
	@Autowired
	public void f1(HotelRepository hr )
	{
		hotelrepo = hr;
	}
	
	
	
	public List<String> findLocationFromHotelTable()
	{
		List<String> location_list = new ArrayList<String>();
		location_list = hotelrepo.gethotelwithdistinctlocation();		
		return location_list;
	}
	
	
}
