package com.travelwish.mylist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="tbl_places")

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;


    private String name;


    @Column(name= "location", unique=true, nullable = false)
    private String location;

    private String reason;
    private Boolean visited;
    private Date created_at;


    public void setId(Integer id) {
        this.placeId = id;
    }
}
