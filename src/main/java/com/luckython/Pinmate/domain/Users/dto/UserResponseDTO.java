package com.luckython.Pinmate.domain.Users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponseDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class join {
        private Long id;            // 이메일
        private String email;       // 비밀번호
        private String image;        // 이미지
    }
}
