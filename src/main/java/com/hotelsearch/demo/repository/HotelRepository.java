package com.hotelsearch.demo.repository;

import com.hotelsearch.demo.model.Hotel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface HotelRepository extends ElasticsearchRepository<Hotel, String> {

    List<Hotel> findByName(String name);

    List<Hotel> findByCity(String city, Pageable pageable);

    List<Hotel> findByCountry(String country);

    List<Hotel> findByFacilityLike(String facility);

    List<Hotel> findByTypeLike(String type);

    List<Hotel> findByType(String type);

//    List<Hotel> findByAutocompleteStartingWith();

}
