package com.luckython.Pinmate.domain.Place.dto;

import com.luckython.Pinmate.domain.Place.entity.ListType;
import com.luckython.Pinmate.domain.Place.entity.PlaceList;
import lombok.Data;

@Data
public class PlaceListRequestDTO {
    @Data
    public static class PlaceListCreateDTO{
        private String title;
        private String subTitle;
        private ListType listType;

        public PlaceList toEntity(){
            return new PlaceList(this.title,this.subTitle,this.listType);
        }
    }
    @Data
    public static class PlaceListSearchDTO{
        private String keyWord;
    }
}
