package com.luckython.Pinmate.domain.Place.entity;

import com.luckython.Pinmate.domain.Users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; //제목
    private String subTitle;
    private ListType listType;
    private int pinColor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public PlaceList(String title, String subTitle, ListType listType, int pinColor){
        this.title = title;
        this.subTitle = subTitle;
        this.listType = listType;
        this.pinColor = pinColor;
    }
    public PlaceList(String title,String subTitle, ListType listType, Users user, int pinColor){
        this.title = title;
        this.subTitle = subTitle;
        this.listType = listType;
        this.user = user;
        this.pinColor = pinColor;
    }
}
