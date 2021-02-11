package com.cdac.proj.spring.crud.repository;
import com.cdac.proj.spring.crud.interfaces.HotelAvailableInterface;
import com.cdac.proj.spring.crud.interfaces.hotelInterface;
import com.cdac.proj.spring.crud.model.AvailableHotel;
import com.cdac.proj.spring.crud.model.Room;

	

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	
	List<Room> findByRoomidNotIn(List<Integer> room_list);

	
	// remove this later
//	@Query(nativeQuery = true,value="select hotel_id ,count(room_id) as total_room,sum(capacity) as total_capacity from Room where room_id not in (:rni) group by hotel_id having total_capacity > :tc")
//	List<HotelAvailableInterface> get_hotel_available_to_interface(@Param("rni") List<Integer> room_occupied,@Param("tc") Integer capacity_needed);

	
	@Query(nativeQuery = true,value="select hotel_id ,count(room_id) as total_room,sum(capacity) as total_capacity from Room where room_id not in (:rni) group by hotel_id having total_room >= :tc")
	List<HotelAvailableInterface> get_hotel_available_to_interface(@Param("rni") List<Integer> room_occupied,@Param("tc") Integer capacity_needed);

	
	
	//	List<AvailableHotel> oncat(@Param("rni") List<Integer> room_occupied,@Param("tc") Integer capacity_needed);
	

	@Query(nativeQuery=true,value="select h.hotel_name,h.hotel_location,h.hotel_sub_location,"
			+ 					  "h.hotel_facilities,h.hotel_type,r.room_name,r.price,r.room_id,h.address, h.hotel_rating,r.room_thumb_img"
			+ 					  " from room as r inner join hotel as h on r.hotel_id = h.hotel_id"
			+ 					  " where r.hotel_id = :hid and r.room_id not in (:rlist) ")
	List<hotelInterface> get_hotel_detail(@Param("hid") Integer hid,@Param("rlist") List<Integer> room_occupied);
	
	
	
	@Query(nativeQuery=true,value="select hotel_location"
			+ " from room as r inner join hotel as h on r.hotel_id = h.hotel_id where r.hotel_id = :hid and r.room_id not in (:rlist) ")
	List<Object []> gla(@Param("hid") Integer hid,@Param("rlist") List<Integer> room_occupied);
	
	
	
	
	List<Room> findByRoomidNotInAndCapacityGreaterThanEqual(List<Integer> room_list,int capacity);
}
