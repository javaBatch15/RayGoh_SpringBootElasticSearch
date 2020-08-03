package com.hotelsearch.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//type deprecated?
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "hotel")
public class Hotel {

    @Id
    private String uid;
    private String name;
    private String city;
    private String state;
    private String country;
    private String facility;
    private String type;
    private Integer reviewCount;


//    public enum Type{
//    STANDARD, DELUXE
//}


}
