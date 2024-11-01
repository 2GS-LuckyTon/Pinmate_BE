package com.luckython.Pinmate.domain.Place.repository;

import com.luckython.Pinmate.domain.Place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
