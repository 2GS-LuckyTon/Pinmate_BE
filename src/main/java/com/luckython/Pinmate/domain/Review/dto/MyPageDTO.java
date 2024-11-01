package com.luckython.Pinmate.domain.Review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyPageDTO {
    private String userEmail;
    private List<ReviewResponseDTO.ReviewReadDTO> myReview;
}
