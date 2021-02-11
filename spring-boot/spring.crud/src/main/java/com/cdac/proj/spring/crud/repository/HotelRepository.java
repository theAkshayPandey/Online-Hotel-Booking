package com.cdac.proj.spring.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.proj.spring.crud.interfaces.HotelWithRoomDataInterface;
import com.cdac.proj.spring.crud.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	// not required by the way remove it
	List<Hotel> findByHotelidIn(List<Integer> hlist);
	
	
	
	
	
	
	// remove this later
	@Query(nativeQuery = true,value="select  h.hotel_id,h.hotel_name,h.hotel_sub_location,h.hotel_facilities,"
								 + "h.hotel_rating,mh.minprice,mh.room_id,h.hotel_type,h.address,h.hotel_thumb_image"
								 + " from hotel h inner join (select hotel_id,room_id,min(price) as minprice"
								 + " from room group by hotel_id) mh on mh.hotel_id = h.hotel_id where h.hotel_id in (:rni) and h.hotel_location = :tc")
	List<Object []> get_hotel_detail_with_room_available(@Param("rni") List<Integer> hotel_id_list,@Param("tc") String locname);
			
	
	
	
	@Query(nativeQuery = true,value="select  h.hotel_id,h.hotel_name,h.hotel_sub_location,h.hotel_facilities,"
			 + "h.hotel_rating,mh.minprice,mh.room_id,h.hotel_type,h.address,h.hotel_thumb_image"
			 + " from hotel h inner join (select hotel_id,room_id,min(price) as minprice"
			 + " from room where room_id not in (:rid)  group by hotel_id) mh on mh.hotel_id = h.hotel_id where h.hotel_id in (:rni) and h.hotel_location = :tc")
	List<HotelWithRoomDataInterface> get_filtered_data(@Param("rid") List<Integer> room_id_list, @Param("rni") List<Integer> hotel_id_list,@Param("tc") String locname);


	
	
	@Query(nativeQuery = true, value="select distinct hotel_location from hotel where hotel_location is not NULL")
	List<String> gethotelwithdistinctlocation();
	
	
	
	
	
//	@Query(nativeQuery = true,value="select h.hotel_id,hotel_name,hotel_sub_location,hotel_facilities,hotel_rating,room_name,price from hotel" +
//	" as h inner join room as r on h.hotel_id = r.hotel_id where h.hotel_id in (:rni) and h.hotel_location = :tc group by h.hotel_id")
//	List<Object []> get_hotel_detail_with_room_available(@Param("rni") List<Integer> hotel_id_list,@Param("tc") String locname);
//	
//	select * from hotel as h inner join room as r on h.hotel_id = r.hotel_id where h.hotel_id in (1,2,3,4,5,6) and h.location_id = 1 group by h.hotel_id;
}
