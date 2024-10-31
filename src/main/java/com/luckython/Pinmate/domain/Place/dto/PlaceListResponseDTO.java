package com.luckython.Pinmate.domain.Place.dto;

import com.luckython.Pinmate.domain.Place.entity.ListType;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PlaceListResponseDTO {
    @Data
    @AllArgsConstructor
    public static class PlaceListCreateDTO{
        private Long id;
        private String title;
        private String subTitle;
        private ListType listType;
        //private String nickName;

        public static PlaceListCreateDTO toDTO(PlaceList placeList){
            return new PlaceListCreateDTO(placeList.getId(),placeList.getTitle(),placeList.getSubTitle(),placeList.getListType());
        }
    }
    @Data
    @AllArgsConstructor
    public static class PlaceListSearchDTO{
        private Long id;
        private String title;
        private String subTitle;
        private ListType listType;

        public static PlaceListSearchDTO toDTO(PlaceList placeList){
            return new PlaceListSearchDTO(placeList.getId(), placeList.getTitle(), placeList.getSubTitle(), placeList.getListType());
        }
    }
}
