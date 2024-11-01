package com.luckython.Pinmate.domain.Favorite;

import com.luckython.Pinmate.domain.Place.dto.PlaceListResponseDTO;
import com.luckython.Pinmate.domain.Place.repository.PlaceListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FavoriteService {
    private final PlaceListRepository placeListRepository;

    /**
     * 장소 리스트 조회
     * @param filter
     * @return placeLists 목록
     */
    public List<PlaceListResponseDTO.PlaceListSearchCntDTO> placeList(int filter) {
        List<Object[]> placeLists = placeListRepository.findAllPlaceList();
        List<PlaceListResponseDTO.PlaceListSearchCntDTO> place = new ArrayList<>();
        for (Object[] objects : placeLists) {
            PlaceListResponseDTO.PlaceListSearchCntDTO placeDto = PlaceListResponseDTO.PlaceListSearchCntDTO.builder()
                    .id((Long) objects[0])
                    .title((String) objects[1])
                    .subTitle((String) objects[2])
                    .favCnt(String.valueOf(objects[4]))
                    .build();
            place.add(placeDto);
        }
        return place;
    }
}
