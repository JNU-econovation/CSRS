package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.dto.ArtCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ArtService {
    private static final String NOT_FOUND_ART_MESSAGE = "해당 예술품을 찾을 수 없습니다.";
    private final ArtRepository artRepository;

    @Transactional
    public Long createArt(ArtCreateRequestDto artCreateRequestDto) {
        Art createdArt = artRepository.save(artCreateRequestDto.toArt());
        return createdArt.getId();
    }

    @Transactional
    public Art selectArt(Long artId) {
        return artRepository.findById(artId)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_ART_MESSAGE));
    }

    @Transactional
    public void deleteArt(Long artId) {
        Art art = artRepository.findById(artId)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_ART_MESSAGE));
        artRepository.delete(art);
    }
}
