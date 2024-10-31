package com.luckython.Pinmate.domain.Users;

import com.luckython.Pinmate.domain.Users.dto.UserRequestDTO;
import com.luckython.Pinmate.domain.Users.dto.UserResponseDTO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * 회원가입
     * @param joinDTO
     * @return 가입완료 회원 id, email, image
     */
    public UserResponseDTO.join join(@RequestBody UserRequestDTO.join joinDTO){
        log.info("회원가입");
        Users user = Users.builder()
                .email(joinDTO.getEmail())
                .password(joinDTO.getPassword())
                .image(joinDTO.getImage())
                .build();

        Users joinUser = userRepository.save(user);
        log.info("회원가입 완료, 사용자 email [{}]", joinUser.getEmail());

        return UserResponseDTO.join.builder()
                .id(joinUser.getId())
                .email(joinUser.getEmail())
                .image(joinUser.getImage())
                .build();
    }

    /**
     * 로그인
     * @param loginDTO
     * @return 로그인 성공한 회원 email 값
     */
    public UserResponseDTO.login loin(@RequestBody UserRequestDTO.login loginDTO, HttpSession session) {
        // 1. 사용자 email 조회
        Optional<Users> user = userRepository.findByEmail(loginDTO.getEmail());

        if (user.isPresent()) {
            // 2. 사용자 비밀번호 일치 확인
            if (user.get().getPassword().equals(loginDTO.getPassword())){
                session.setAttribute("userId", loginDTO.getEmail());
                session.setAttribute("userImage", user.get().getImage());
                session.setMaxInactiveInterval(1800);

                log.info("로그인 성공, 사용자 email [{}]", loginDTO.getEmail().toString());
                return UserResponseDTO.login.builder()
                        .email(loginDTO.getEmail())
                        .build();
            } else throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else throw new NoSuchElementException("해당 이메일에 해당하는 유저가 존재하지 않습니다.");
    }

    /**
     * 로그아웃
     * @param session
     * @return String
     */
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }
}