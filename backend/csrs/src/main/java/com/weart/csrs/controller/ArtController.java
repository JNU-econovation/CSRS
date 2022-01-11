package com.weart.csrs.controller;

import com.weart.csrs.dto.ArtCreateRequestDto;
import com.weart.csrs.service.ArtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;

    @PostMapping("api/art/save")
    public Long artSave(@RequestBody ArtCreateRequestDto artCreateRequestDto) {
        return artService.createArt(artCreateRequestDto);
    }

}
