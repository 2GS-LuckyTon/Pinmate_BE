package com.luckython.Pinmate.domain.Review.entity;

import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    //장소리스트id
    @ManyToOne
    @JoinColumn(name = "placelist_id")
    private PlaceList placeList;
    // 멤버
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
    public Review(String content){
        this.content = content;
    }
    public Review(String content, user user,PlaceList placeList){
        this.content = content;
        this.user = user;
        this.placeList = placeList;
    }
    public void patch(Review review){
        this.content = review.getContent();
    }
}
