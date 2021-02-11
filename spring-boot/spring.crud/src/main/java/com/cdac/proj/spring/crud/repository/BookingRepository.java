package com.cdac.proj.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.proj.spring.crud.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
