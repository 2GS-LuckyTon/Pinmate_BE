package com.luckython.Pinmate.domain.Place.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.luckython.Pinmate.domain.Place.dto.PlaceListRequestDTO;
import com.luckython.Pinmate.domain.Place.dto.PlaceListResponseDTO;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Place.repository.PlaceListRepository;
import com.luckython.Pinmate.domain.Users.UserRepository;
import com.luckython.Pinmate.domain.Users.Users;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceListService {
    private final PlaceListRepository placeListRepository;
    private final UserRepository userRepository;

//    private final AmazonS3 amazonS3;
//    @Value("pinmate")
//    private String bucket;

    //리스트 생성
    public PlaceListResponseDTO.PlaceListCreateDTO create(PlaceListRequestDTO.PlaceListCreateDTO placeListCreateDTO,String userEmail){
        Optional<Users> user = userRepository.findByEmail(userEmail);
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
    public List<PlaceListResponseDTO.PlaceListSearchDTO> myList(String userEmail){
        List<PlaceList> myList = placeListRepository.findByUserEmail(userEmail);
        List<PlaceListResponseDTO.PlaceListSearchDTO> resultList = convertToDto(myList);
        return resultList;
    }



    //List<placeList>를 dto로 변환
    public List<PlaceListResponseDTO.PlaceListSearchDTO> convertToDto(List<PlaceList> placeLists){
        return placeLists.stream()
                .map(place -> new PlaceListResponseDTO.PlaceListSearchDTO(place.getId(),place.getTitle(), place.getSubTitle(), place.getListType()))
                .collect(Collectors.toList());
    }

    //사진 생성
//        public String upload(MultipartFile multipartFile) throws IOException {
//        String originalFileName = multipartFile.getOriginalFilename();
//        //UUID 추가
//        String uuid = UUID.randomUUID().toString();
//        String uniqueFileName = uuid + "_" + originalFileName.replaceAll("\\s","_");
//
//        //String fileName = dirName + "/" + uniqueFileName;
//        log.info("fileName: " + uniqueFileName);
//
//        ObjectMetadata metadata = new ObjectMetadata();
//        metadata.setContentLength(multipartFile.getSize());
//        metadata.setContentType(multipartFile.getContentType());
//
//        amazonS3.putObject(bucket, uniqueFileName,multipartFile.getInputStream(), metadata);
//        String imgUrl = amazonS3.getUrl(bucket, uniqueFileName).toString();
//        return imgUrl;
//    }
}
