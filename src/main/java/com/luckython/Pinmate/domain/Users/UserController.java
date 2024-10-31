package com.luckython.Pinmate.domain.Users;

import com.luckython.Pinmate.domain.Users.dto.UserRequestDTO;
import com.luckython.Pinmate.domain.Users.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    /**
     * 회원가입
     * @param joinDTO
     * @return 가입완료 회원 id, email, image
     */
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserRequestDTO.join joinDTO) {
        return ResponseEntity.ok().body(userService.join(joinDTO));
    }
}
