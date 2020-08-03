package com.hotelsearch.demo;

import com.hotelsearch.demo.model.Hotel;
import com.hotelsearch.demo.repository.HotelRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private HotelRepository repository;

    @PostMapping("/saveHotels")
    public int saveHotels(@RequestBody List<Hotel> hotels){
        repository.saveAll(hotels);

        return hotels.size();
    }

    @GetMapping("/findByName/{hotelName}")
        public List<Hotel> findByName(@PathVariable String hotelName) {
        return repository.findByName(hotelName);
    }

    @GetMapping("/findByCity/{city}/{page}")
    public List<Hotel> findByCity(@PathVariable String city, @PathVariable String page) {
        return repository.findByCity(city, PageRequest.of(Integer.parseInt(page), 2));
    }

    @GetMapping("/findByCountry/{country}")
    public List<Hotel> findByCountry(@PathVariable String country) {
        return repository.findByCountry(country);
    }

    @GetMapping("/filterByFacility/{facility}")
    public List<Hotel> filterByFacility(@PathVariable String facility) {
        return repository.findByFacilityLike(facility);
    }

    @GetMapping("/filterByType/{type}")
    public List<Hotel> filterByType(@PathVariable String type) {
        return repository.findByTypeLike(type);
    }

//    @GetMapping("/filterTest/{type}")
//    public List<Hotel> filterByTypePrototype(@PathVariable String type) {
//        String[] stringList = type.split(" ");
//        if(stringList.length <= 1){
//            return repository.findByTypeLike(type);
//        }
//        else{
//            List<Hotel> arrList = new ArrayList<>();
//            for(String s: stringList) {
//                arrList.addAll(repository.findByTypeLike(s));
//            }
//            return arrList;
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
