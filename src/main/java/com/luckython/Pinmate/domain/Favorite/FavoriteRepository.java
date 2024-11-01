package com.luckython.Pinmate.domain.Favorite;

import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
