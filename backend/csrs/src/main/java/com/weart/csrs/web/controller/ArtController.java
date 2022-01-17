package com.weart.csrs.web.controller;

import com.weart.csrs.service.ArtService;
import com.weart.csrs.web.dto.ArtCreateRequestDto;
import com.weart.csrs.web.dto.ArtResponeDto;
import com.weart.csrs.web.dto.ArtWithPaginationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;

    @PostMapping("api/art")
    public Long artSave(@RequestBody ArtCreateRequestDto artCreateRequestDto) {
        return artService.createArt(artCreateRequestDto);
    }

    @GetMapping("api/arts/{artId}")
    public ArtResponeDto selectArt(@PathVariable Long artId) {
        return artService.selectArt(artId);
    }

    @GetMapping("api/arts")
    public ArtWithPaginationDto selectAllArts(@PageableDefault(size = 21, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return artService.selectAllWithPagination(pageable);
    }

    @PutMapping("api/arts/{artId}")
    public Long artUpdate(@PathVariable Long artId, @RequestBody ArtCreateRequestDto artCreateRequestDto) {
        return artService.updateArt(artId, artCreateRequestDto);
    }

    @DeleteMapping("api/arts/{artId}")
    public Long deleteArt(@PathVariable Long artId) {
        artService.deleteArt(artId);
        return artId;
    }

    @GetMapping("api/artnames/{artName}")
    public List<ArtResponeDto> searchByName(@PathVariable String artName) {
        return artService.selectArtByTile(artName);
    }
}
