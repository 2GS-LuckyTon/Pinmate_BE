package com.luckython.Pinmate.domain.Review.repository;

import com.luckython.Pinmate.domain.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByPlaceListId(Long PlaceListId);
    List<Review> findByUserEmail(String userEmail);
}
