package com.cdac.proj.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.proj.spring.crud.model.Hotelimages;

public interface HotelimagesRepository extends JpaRepository<Hotelimages, Integer> {

	List<Hotelimages> findByHotelid(int id);
}
