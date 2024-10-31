package com.luckython.Pinmate.domain.Review.controller;

import com.luckython.Pinmate.domain.Review.dto.ReviewRequestDTO;
import com.luckython.Pinmate.domain.Review.dto.ReviewResponseDTO;
import com.luckython.Pinmate.domain.Review.service.ReviewService;
import com.luckython.Pinmate.domain.Review.service.ReviewServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    //리뷰 생성
    @PostMapping("/api/review/{placelistId}/create")
    public ResponseEntity<?> create(@PathVariable Long placelistId, ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO, HttpSession session){
        Long userId = 1L;//session.getAttribute();
        ReviewResponseDTO.ReviewCreateDTO result = reviewService.create(reviewCreateDTO,userId,placelistId);
        return ResponseEntity.ok().body(result);
    }
    //리뷰 조회
    @GetMapping("/api/review/{placelistId}")
    public ResponseEntity<?> read(@PathVariable Long placelistId){
        List<ReviewResponseDTO.ReviewReadDTO> result = reviewService.readReview(placelistId);
        return ResponseEntity.ok().body(result);
    }
    //리뷰 삭제
    @PostMapping("/api/review/delete/{reviewid}")
    public ResponseEntity<?> delete(@PathVariable Long reviewid){
        reviewService.delete(reviewid);
        String result = "리뷰 삭제함";
        return ResponseEntity.ok().body(result);
    }
    //리뷰 수정
    @PostMapping("/api/review/update/{reviewid}")
    public ResponseEntity<?> update(@PathVariable Long reviewid, ReviewRequestDTO.ReviewUpdateDTO reviewUpdateDTO){
        ReviewResponseDTO.ReviewCreateDTO result = reviewService.update(reviewUpdateDTO,reviewid);
        return ResponseEntity.ok().body(result);
    }
}
