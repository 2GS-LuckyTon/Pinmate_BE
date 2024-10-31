package com.luckython.Pinmate.domain.Place.controller;

import com.luckython.Pinmate.domain.Place.dto.PlaceListRequestDTO;
import com.luckython.Pinmate.domain.Place.dto.PlaceListResponseDTO;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Place.service.PlaceListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PlaceListController {
    private final PlaceListService placeListService;

    //장소 리스트 생성
    @PostMapping("/api/placelist/create")
    public ResponseEntity<?> createPlaceList(PlaceListRequestDTO.PlaceListCreateDTO placeListCreateDTO, HttpSession session){
        Long userId = 1L;//session.getAttribute();
        PlaceListResponseDTO.PlaceListCreateDTO result = placeListService.create(placeListCreateDTO,userId);
        return ResponseEntity.ok().body(result);
    }
    //장소 리스트 검색
    @PostMapping("/api/placelist/search")
    public ResponseEntity<?> searchPlaceList(PlaceListRequestDTO.PlaceListSearchDTO placeListSearchDTO){
        List<PlaceListResponseDTO.PlaceListSearchDTO> result = placeListService.search(placeListSearchDTO);
        return ResponseEntity.ok().body(result);
    }
    //나의 장소리스트 목록
    @GetMapping("api/myplacelist")
    public ResponseEntity<?> myPlaceList(HttpSession session){
        Long userId = 1L;//session.getAttribute();
        List<PlaceListResponseDTO.PlaceListSearchDTO> result = placeListService.myList(userId);
        return ResponseEntity.ok().body(result);
    }
}
