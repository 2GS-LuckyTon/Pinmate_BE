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
        private String nickName;
        //작성자

        public static ReviewCreateDTO toDTO(Review review){
            return new ReviewCreateDTO(review.getId(),review.getContent(),review.getUser().getNickName());
        }
    }
    @Data
    @AllArgsConstructor
    public static class ReviewReadDTO{
        //private Long id; //리뷰 엔티티 아이디
        private String content;
        private String nickName;
    }
}
