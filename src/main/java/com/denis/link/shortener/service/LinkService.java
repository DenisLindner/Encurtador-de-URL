package com.denis.link.shortener.service;

import com.denis.link.shortener.exceptions.CaracterInvalidoException;
import com.denis.link.shortener.exceptions.LinkJaExistenteException;
import com.denis.link.shortener.exceptions.LinkNaoEncontradoException;
import com.denis.link.shortener.exceptions.MinimoDeCaracteresNaoAlcancadoException;
import com.denis.link.shortener.model.LinkEntity;
import com.denis.link.shortener.model.LinkRequest;
import com.denis.link.shortener.model.LinkResponse;
import com.denis.link.shortener.repository.LinkRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LinkService {

    private final LinkRepository linkRepository;
    private final String BASE_URL = "http://localhost:9999/";

    public LinkResponse postLink(LinkRequest linkRequest, String customShortLink) {
        if (customShortLink == null){
            customShortLink = getShortLink();
        } else {
            if (linkRepository.existsByShortLink(customShortLink)) {
                throw new LinkJaExistenteException(customShortLink);
            }
            if (customShortLink.length() < 3) {
                throw new MinimoDeCaracteresNaoAlcancadoException();
            }
            if (customShortLink.contains("/")) {
                throw new CaracterInvalidoException();
            }
        }
        return toResponse(linkRepository.save(new LinkEntity(linkRequest.originalLink(), customShortLink)));
    }

    public String getOriginalLink(String shortLink) {
        if (!linkRepository.existsByShortLink(shortLink)) {
            throw new LinkNaoEncontradoException(shortLink);
        }
        LinkEntity linkEntity = linkRepository.findByShortLink(shortLink);
        return linkEntity.getOriginalLink();
    }

    public Integer getQtdAllLinksCreated() {
        return linkRepository.findAll().size();
    }

    public Integer getQtdLinksCreatedToday() {
        LocalDate today = LocalDate.now();
        return linkRepository.countByCreatedAtBetween(today.atStartOfDay(), today.atTime(LocalTime.MAX));
    }

    public String getShortLink() {
        while (true) {
            String url = RandomStringUtils.randomAlphanumeric(5, 10);
            if (!linkRepository.existsByShortLink(url)) {
                return url;
            }
        }
    }

    public LinkResponse toResponse(LinkEntity linkEntity) {
        return new LinkResponse(
                linkEntity.getId(),
                linkEntity.getOriginalLink(),
                BASE_URL+linkEntity.getShortLink(),
                linkEntity.getCreatedAt()
        );
    }
}
