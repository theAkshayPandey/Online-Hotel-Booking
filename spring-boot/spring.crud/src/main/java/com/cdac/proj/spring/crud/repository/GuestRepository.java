package com.cdac.proj.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.proj.spring.crud.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
