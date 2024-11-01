package com.luckython.Pinmate.domain.Place.repository;

import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceListRepository extends JpaRepository<PlaceList, Long> {
    List<PlaceList> findByTitleContaining(String keyword);
    List<PlaceList> findByUserEmail(String email);

    @Query(value = "SELECT pl.id AS id, pl.title AS title, pl.sub_title AS subTitle, pl.list_type AS listType, COUNT(f.id) AS favCnt " +
            "FROM place_list pl " +
            "LEFT JOIN favorite f ON pl.id = f.placeList_id " +
            "GROUP BY pl.id " +
            "ORDER BY favCnt DESC " +
            "LIMIT 20", nativeQuery = true)
    List<Object[]> findAllPlaceList();
}
