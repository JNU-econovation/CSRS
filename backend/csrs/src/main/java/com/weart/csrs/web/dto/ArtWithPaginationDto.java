package com.weart.csrs.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ArtWithPaginationDto {
    private List<ArtResponeDto> artResponeDtos;
    private int totalPages;

    public ArtWithPaginationDto(List<ArtResponeDto> artResponeDtos, int totalPages) {
        this.artResponeDtos = artResponeDtos;
        this.totalPages = totalPages;
    }
}
