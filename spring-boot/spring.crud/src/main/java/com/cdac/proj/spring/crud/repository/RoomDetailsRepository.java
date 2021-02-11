package com.cdac.proj.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.proj.spring.crud.model.RoomDetails;

public interface RoomDetailsRepository extends JpaRepository<RoomDetails, Integer>{

	
	List<RoomDetails> findByRoomid(int rid);
}
