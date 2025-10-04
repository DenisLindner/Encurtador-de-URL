package com.denis.link.shortener.model;

import java.time.LocalDateTime;

public record LinkResponse(Long id, String originalLink, String shortLink, LocalDateTime createdAt) {
}
