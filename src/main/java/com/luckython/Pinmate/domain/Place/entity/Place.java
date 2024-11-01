package com.luckython.Pinmate.domain.Place.entity;

import com.luckython.Pinmate.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placeName;
    private String placeContent;
    private double latitude; //위도
    private double longitude; //경도
    @ManyToOne
    @JoinColumn(name="placelist_id")
    private PlaceList placeList;

    public Place(Long id, String placeName, String placeContent, double latitude, double longitude, PlaceList placeList) {
        this.id = id;
        this.placeName = placeName;
        this.placeContent = placeContent;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placeList = placeList;
    }
}
