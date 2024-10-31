package com.luckython.Pinmate.domain.Review.dto;

import com.luckython.Pinmate.domain.Review.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ReviewResponseDTO {
    @Data
    @AllArgsConstructor
    public static class ReviewCreateDTO{
        private Long id;
        private String content;
        //작성자

        public static ReviewCreateDTO toDTO(Review review){
            return new ReviewCreateDTO(review.getId(),review.getContent());
        }
    }
}
