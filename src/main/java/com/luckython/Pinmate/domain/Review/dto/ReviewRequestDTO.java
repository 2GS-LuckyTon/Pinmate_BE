package com.luckython.Pinmate.domain.Review.dto;

import com.luckython.Pinmate.domain.Review.entity.Review;
import lombok.Data;

@Data
public class ReviewRequestDTO {
    @Data
    public static class ReviewCreateDTO{
        private String content;

        public Review toEntity(){
            return new Review(this.content);
        }
    }
}
