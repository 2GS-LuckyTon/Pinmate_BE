package com.luckython.Pinmate.domain.Review.repository;

import com.luckython.Pinmate.domain.Review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
