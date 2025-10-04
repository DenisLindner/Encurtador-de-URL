package com.denis.link.shortener.model;

import jakarta.validation.constraints.NotBlank;

public record LinkRequest(@NotBlank String originalLink) {
}
