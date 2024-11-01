package com.luckython.Pinmate.domain.Place.dto;

import com.luckython.Pinmate.domain.Place.entity.ListType;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import lombok.*;

import java.util.List;

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

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PlaceListSearchCntDTO{
        private Long id;
        private String title;
        private String subTitle;
        private ListType listType;
        private String favCnt;
    }

    private List<PlaceListDTO> placeLists;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PlaceListDTO {
        private Long id;
        private String title;
        private String subTitle;
        private List<PlaceDTO> places;

        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class PlaceDTO {
            private Long id;
            private String placeName;
            private double latitude;
            private double longitude;
        }
    }
}
