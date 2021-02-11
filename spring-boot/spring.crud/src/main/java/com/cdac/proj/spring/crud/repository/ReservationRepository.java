package com.cdac.proj.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.cdac.proj.spring.crud.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>  {

	List<Reservation> findByCheckoutGreaterThanEqualAndCheckinLessThanEqual(LocalDateTime checkout,LocalDateTime checkin);	
	
	
	// mine
	List<Reservation> findByCheckoutLessThanEqualAndCheckinGreaterThanEqual(LocalDateTime checkout,LocalDateTime checkin);	
}
