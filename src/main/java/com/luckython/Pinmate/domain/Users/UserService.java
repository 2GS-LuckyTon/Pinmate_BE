package com.luckython.Pinmate.domain.Users;

import com.luckython.Pinmate.domain.Users.dto.UserRequestDTO;
import com.luckython.Pinmate.domain.Users.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        log.info("회원가입 완료, 사용자 email {}", joinUser.getEmail());

        return UserResponseDTO.join.builder()
                .id(joinUser.getId())
                .email(joinUser.getEmail())
                .image(joinUser.getImage())
                .build();
    }
}