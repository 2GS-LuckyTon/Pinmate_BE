package com.luckython.Pinmate.domain.Favorite;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;
    /**
     * 장소 리스트 조회
     * @param filter (최근순, 저장순 조회조건)
     * @return
     */
    @PostMapping("/api/favorite")
    public ResponseEntity<?> placeList(@RequestParam("filter") int filter) {
        return ResponseEntity.ok().body(favoriteService.placeList(filter));
    }
}
