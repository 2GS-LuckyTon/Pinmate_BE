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
        private Long id;            // 구분자
        private String email;       // 이메일
        private String image;        // 이미지
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class login {
        private String email;       // 이메일
    }
}