package com.weart.csrs.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ArtWithPaginationDto {
    private List<ArtResponseDto> artResponseDto;
    private int totalPages;

    public ArtWithPaginationDto(List<ArtResponseDto> artResponseDto, int totalPages) {
        this.artResponseDto = artResponseDto;
        this.totalPages = totalPages;
    }
}
