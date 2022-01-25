package com.weart.csrs.service;

import com.weart.csrs.domain.art.Art;
import com.weart.csrs.domain.art.ArtRepository;
import com.weart.csrs.web.dto.ArtCreateRequestDto;
import com.weart.csrs.web.dto.ArtResponeDto;
import com.weart.csrs.web.dto.ArtWithPaginationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.weart.csrs.util.StringUtils.extractFileNameFromFilePath;

@RequiredArgsConstructor
@Service
public class ArtService {
    private static final String NOT_FOUND_ART_MESSAGE = "해당 예술품을 찾을 수 없습니다.";
    private final ArtRepository artRepository;
    private final S3Service s3Service;

    @Transactional
    public Long createArt(ArtCreateRequestDto artCreateRequestDto) throws IOException {
        String uploadFilePath = s3Service.upload(artCreateRequestDto.getMultipartFile(), "profile");
        artCreateRequestDto.setUploadFilePath(uploadFilePath);
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
    public ArtWithPaginationDto selectAllWithPagination(Pageable pageable) {
        Page<Art> all = artRepository.findAll(pageable);
        List<ArtResponeDto> artResponeDtos = all.getContent().stream()
                .map(ArtResponeDto::new)
                .collect(Collectors.toList());
        int totalPage = all.getTotalPages();
        return new ArtWithPaginationDto(artResponeDtos, totalPage);
    }

    @Transactional
    public Long updateArt(Long id, ArtCreateRequestDto artCreateRequestDto) throws IOException {
        Art art = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ART_MESSAGE));
        if (art.checkBidTime()) {
            throw new IllegalArgumentException("수정할 수 없음");
        }
        String savedFileName = extractFileNameFromFilePath(art.getUploadFilePath());
        String uploadFilePath = s3Service.update(artCreateRequestDto.getMultipartFile(), "profile", savedFileName);
        artCreateRequestDto.setUploadFilePath(uploadFilePath);
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
