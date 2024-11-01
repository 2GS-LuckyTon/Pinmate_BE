package com.luckython.Pinmate.domain.Place.controller;

import com.luckython.Pinmate.domain.Place.dto.PlaceListRequestDTO;
import com.luckython.Pinmate.domain.Place.dto.PlaceListResponseDTO;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Place.service.PlaceListService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PlaceListController {
    private final PlaceListService placeListService;

    //장소 리스트 생성
    @PostMapping("/api/placelist/create")
    public ResponseEntity<?> createPlaceList(@RequestBody PlaceListRequestDTO.PlaceListCreateDTO placeListCreateDTO, HttpSession session){
        String userEmail = (String) session.getAttribute("userId");
        PlaceListResponseDTO.PlaceListCreateDTO result = placeListService.create(placeListCreateDTO,userEmail);
        return ResponseEntity.ok().body(result);
    }
    //장소 리스트 검색
    @PostMapping("/api/placelist/search")
    public ResponseEntity<?> searchPlaceList(@RequestBody PlaceListRequestDTO.PlaceListSearchDTO placeListSearchDTO){
        List<PlaceListResponseDTO.PlaceListSearchDTO> result = placeListService.search(placeListSearchDTO);
        return ResponseEntity.ok().body(result);
    }
    //나의 장소리스트 목록
    @GetMapping("api/myplacelist")
    public ResponseEntity<?> myPlaceList(HttpSession session){
        String userEmail = (String) session.getAttribute("userId");
        List<PlaceListResponseDTO.PlaceListSearchDTO> result = placeListService.myList(userEmail);
        return ResponseEntity.ok().body(result);
    }

    /**
     * 장소 저장
     * @param placeName
     * @param placeContent
     * @param latitude
     * @param longitude
     * @return String
     */
    @PostMapping("/api/placelist/addPlace")
    public ResponseEntity<?> addPlace(@RequestParam("placeName") String placeName,
                                      @RequestParam("placeContent") String placeContent,
                                      @RequestParam("latitude") Double latitude,
                                      @RequestParam("longitude") Double longitude) {
        return ResponseEntity.ok().body(placeListService.addPlace(placeName, placeContent, latitude, longitude));
    }
}
