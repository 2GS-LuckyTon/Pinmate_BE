package com.luckython.Pinmate.domain.Users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class join {
        private String email;     // 이메일
        private String password;  // 비밀번호
        private String image;     // 이미지
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class login {
        private String email;    // 이메일
        private String password; // 비밀번호
    }
}