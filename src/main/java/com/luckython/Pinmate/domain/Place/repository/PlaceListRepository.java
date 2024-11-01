package com.luckython.Pinmate.domain.Place.repository;

import com.luckython.Pinmate.domain.Place.entity.Place;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceListRepository extends JpaRepository<PlaceList, Long> {
    List<PlaceList> findByTitleContaining(String keyword);
    List<PlaceList> findByUserEmail(String email);
}
