package com.luckython.Pinmate.domain.Place.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceList_Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "placeList_id")
    private PlaceList placeList;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
