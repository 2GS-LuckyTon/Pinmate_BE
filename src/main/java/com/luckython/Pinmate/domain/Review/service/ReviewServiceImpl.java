package com.luckython.Pinmate.domain.Review.service;

import com.luckython.Pinmate.domain.Review.dto.ReviewRequestDTO;
import com.luckython.Pinmate.domain.Review.dto.ReviewResponseDTO;
import com.luckython.Pinmate.domain.Review.entity.Review;
import com.luckython.Pinmate.domain.Review.repository.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    //리뷰 생성
    public ReviewResponseDTO.ReviewCreateDTO create(ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO, HttpSession session){
        Review review = reviewCreateDTO.toEntity();
        reviewRepository.save(review);
        return ReviewResponseDTO.ReviewCreateDTO.toDTO(review);
    }
    //리뷰 조회


}
