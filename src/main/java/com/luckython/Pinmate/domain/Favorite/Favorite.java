package com.luckython.Pinmate.domain.Favorite;

import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import com.luckython.Pinmate.domain.Users.Users;
import com.luckython.Pinmate.global.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Favorite extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   //구분자
    @ManyToOne
    @JoinColumn(name="placelist_id")
    private PlaceList placeList;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    public Favorite(Long id, PlaceList placeList, Users users) {
        this.id = id;
        this.placeList = placeList;
        this.users = users;
    }
}
