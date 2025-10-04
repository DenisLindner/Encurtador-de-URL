package com.denis.link.shortener.repository;

import com.denis.link.shortener.model.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Long> {

    Boolean existsByShortLink(String shortLink);
    LinkEntity findByShortLink(String shortLink);
}
