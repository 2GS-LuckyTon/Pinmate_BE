package com.luckython.Pinmate.domain.Review.service;

import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Place.repository.PlaceListRepository;
import com.luckython.Pinmate.domain.Review.dto.ReviewRequestDTO;
import com.luckython.Pinmate.domain.Review.dto.ReviewResponseDTO;
import com.luckython.Pinmate.domain.Review.entity.Review;
import com.luckython.Pinmate.domain.Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final PlaceListRepository placeListRepository;
    //private final UserRepository userRepository;

    //리뷰 생성
    public ReviewResponseDTO.ReviewCreateDTO create(ReviewRequestDTO.ReviewCreateDTO reviewCreateDTO, Long userId,Long placeListId){
        //세션에서 사용자 찾기
        //Optional<user> user = userRepository.findById(userId);
        Optional<PlaceList> placeList = placeListRepository.findById(placeListId);
        if(placeList.isPresent()){
            Review review = new Review(reviewCreateDTO.getContent(),user.get(),placeList.get());
            reviewRepository.save(review);
            return ReviewResponseDTO.ReviewCreateDTO.toDTO(review);
        }
        else{
            throw new IllegalArgumentException("장소리스트 오류");
        }
    }
    //리뷰 조회
    public List<ReviewResponseDTO.ReviewReadDTO> readReview(Long PlaceListId){
        List<Review> list = reviewRepository.findByPlaceListId(PlaceListId);
        List<ReviewResponseDTO.ReviewReadDTO> resultList = convertToDTO(list);
        return resultList;
    }
    //리뷰 삭제
    public void delete(Long id){
        Optional<Review> review = reviewRepository.findById(id);
        if(review.isPresent()){
            reviewRepository.delete(review.get());
            log.info("리뷰삭제함");
        }
    }
    //리뷰 수정
    @Transactional
    public ReviewResponseDTO.ReviewCreateDTO update(ReviewRequestDTO.ReviewUpdateDTO reviewUpdateDTO,Long id){
        Optional<Review> review = reviewRepository.findById(id);
        Review update = reviewUpdateDTO.toEntity();
        if(review.isPresent()){
            Review target = review.get();
            target.patch(update);
            return ReviewResponseDTO.ReviewCreateDTO.toDTO(target);
        }
        else{
            throw new IllegalArgumentException("리뷰가 존재하지 않음");
        }
    }
    //변환
    public List<ReviewResponseDTO.ReviewReadDTO> convertToDTO(List<Review> reviewList){
        return reviewList.stream()
                .map(review -> new ReviewResponseDTO.ReviewReadDTO(review.getContent(),review.getUser().getNickName()))
                .collect(Collectors.toList());
    }
}
