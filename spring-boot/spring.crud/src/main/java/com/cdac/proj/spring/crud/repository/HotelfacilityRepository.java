package com.cdac.proj.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.proj.spring.crud.model.Hotelfacility;

public interface HotelfacilityRepository extends JpaRepository<Hotelfacility, Integer>{

	
	List<Hotelfacility> findByHotelid(int hid);
}
