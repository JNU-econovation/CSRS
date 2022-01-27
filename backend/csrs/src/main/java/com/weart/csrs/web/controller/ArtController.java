package com.weart.csrs.web.controller;

import com.weart.csrs.service.ArtService;
import com.weart.csrs.service.BidService;
import com.weart.csrs.web.dto.ArtCreateRequestDto;
import com.weart.csrs.web.dto.ArtResponseDto;
import com.weart.csrs.web.dto.ArtWithPaginationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;
    private final BidService bidService;

    @PostMapping("api/art")
    public Long artSave(@ModelAttribute ArtCreateRequestDto artCreateRequestDto) throws IOException {
        return artService.createArt(artCreateRequestDto);
    }

    @GetMapping("api/arts/{artId}")
    public ArtResponseDto selectArt(@PathVariable Long artId) {
        ArtResponseDto artResponseDto = artService.selectArt(artId);
        artResponseDto.setMaxPrice(bidService.selectBidMaxPrice(artId));
        return artResponseDto;
    }

    @GetMapping("api/arts")
    public ArtWithPaginationDto selectAllArts(@PageableDefault(size = 18, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return artService.selectAllWithPagination(pageable);
    }

    @PutMapping("api/arts/{artId}")
    public Long artUpdate(@PathVariable Long artId, @ModelAttribute ArtCreateRequestDto artCreateRequestDto) throws IOException {
        return artService.updateArt(artId, artCreateRequestDto);
    }

    @DeleteMapping("api/arts/{artId}")
    public Long deleteArt(@PathVariable Long artId) {
        artService.deleteArt(artId);
        return artId;
    }

    @GetMapping("api/arts/name/{artName}")
    public List<ArtResponseDto> searchByName(@PathVariable String artName) {
        return artService.selectArtByTile(artName);
    }

    @GetMapping("api/arts/category/{artCategory}")
    public ArtWithPaginationDto searchByCategory(@PathVariable String artCategory, @PageableDefault(size = 18, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return artService.selectArtByCategory(artCategory, pageable);
    }

    @GetMapping("api/arts/page")
    public Integer selectAllArtsPage(@PageableDefault(size = 18, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return artService.selectNewArtPages(pageable);
    }

    @GetMapping("api/arts/page/{category}")
    public Integer selectAllArtsPageCategory(@PathVariable String category, @PageableDefault(size = 18, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return artService.selectCategoryArtPages(category, pageable);
    }
}
