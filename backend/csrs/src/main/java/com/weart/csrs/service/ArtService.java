package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.web.dto.ArtCreateRequestDto;
import com.weart.csrs.web.dto.ArtResponeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArtService {
    private static final String NOT_FOUND_ART_MESSAGE = "해당 예술품을 찾을 수 없습니다.";
    private final ArtRepository artRepository;

    @Transactional
    public Long createArt(ArtCreateRequestDto artCreateRequestDto) {
        Art art = artRepository.save(artCreateRequestDto.toArt());
        return art.getId();
    }

    @Transactional
    public ArtResponeDto selectArt(Long artId) {
        Art art = artRepository.findById(artId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        return new ArtResponeDto(art);
    }

    @Transactional
    public List<ArtResponeDto> selectAll() {
        return artRepository.findAll().stream()
                .map(ArtResponeDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long updateArt(Long id, ArtCreateRequestDto artCreateRequestDto) {
        Art art = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        art.update(artCreateRequestDto);

        return id;
    }

    @Transactional
    public void deleteArt(Long artId) {
        Art art = artRepository.findById(artId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        artRepository.delete(art);
    }

    @Transactional
    public List<ArtResponeDto> selectArtByTile(String title) {
        List<Art> arts = artRepository.findByTitle(title);
        List<ArtResponeDto> searchArts = arts.stream().map(ArtResponeDto::new).collect(Collectors.toList());
        if (searchArts.isEmpty()) {
            throw new IllegalArgumentException(NOT_FOUND_ART_MESSAGE);
        }
        return searchArts;
    }
}
