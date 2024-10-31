package com.luckython.Pinmate.domain.Place.service;

import com.luckython.Pinmate.domain.Place.dto.PlaceListRequestDTO;
import com.luckython.Pinmate.domain.Place.dto.PlaceListResponseDTO;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Place.repository.PlaceListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceListService {
    private final PlaceListRepository placeListRepository;
    //private final UserRepository userRepository;

    //리스트 생성
    public PlaceListResponseDTO.PlaceListCreateDTO create(PlaceListRequestDTO.PlaceListCreateDTO placeListCreateDTO,Long userId){
        //Optional<user> user = userRepository.findById(userId);
        //PlaceList placeList = placeListCreateDTO.toEntity();
        if(user.isPresent()){
            PlaceList placeList = new PlaceList(placeListCreateDTO.getTitle(), placeListCreateDTO.getSubTitle(), placeListCreateDTO.getListType(),user.get());
            placeListRepository.save(placeList);
            return PlaceListResponseDTO.PlaceListCreateDTO.toDTO(placeList);
        }
        else{
            throw new IllegalArgumentException("유저가 없음");
        }
    }
    //리스트에 장소 저장??
    //장소 리스트 검색 //제목에 검색어 포함하는 장소리스트들 반환
    public List<PlaceListResponseDTO.PlaceListSearchDTO> search(PlaceListRequestDTO.PlaceListSearchDTO placeListSearchDTO){
        String keyWord = placeListSearchDTO.getKeyWord();
        List<PlaceList> result = placeListRepository.findByTitleContaining(keyWord);
        List<PlaceListResponseDTO.PlaceListSearchDTO> dtos = convertToDto(result);
        return dtos;
    }
    //나의 장소리스트 목록
    public List<PlaceListResponseDTO.PlaceListSearchDTO> myList(Long userId){
        List<PlaceList> myList = placeListRepository.findByUserId(userId);
        List<PlaceListResponseDTO.PlaceListSearchDTO> resultList = convertToDto(myList);
        return resultList;
    }



    //List<placeList>를 dto로 변환
    public List<PlaceListResponseDTO.PlaceListSearchDTO> convertToDto(List<PlaceList> placeLists){
        return placeLists.stream()
                .map(place -> new PlaceListResponseDTO.PlaceListSearchDTO(place.getId(),place.getTitle(), place.getSubTitle(), place.getListType()))
                .collect(Collectors.toList());
    }
}
