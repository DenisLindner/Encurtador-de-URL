package com.denis.link.shortener.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalLink;

    @Column(nullable = false, unique = true)
    private String shortLink;

    private LocalDateTime createdAt;

    public LinkEntity(String originalLink, String shortLink) {
        this.originalLink = originalLink;
        this.shortLink = shortLink;
        this.createdAt = LocalDateTime.now();
    }
}
