package com.denis.link.shortener.controller;

import com.denis.link.shortener.model.LinkRequest;
import com.denis.link.shortener.model.LinkResponse;
import com.denis.link.shortener.service.LinkService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LinkCotroller {

    private final LinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<LinkResponse> postLink(@RequestBody @Valid LinkRequest linkRequest, @RequestParam(required = false) String customShortLink) {
        return ResponseEntity.status(201).body(linkService.postLink(linkRequest, customShortLink));
    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<String> getOriginalLink(@PathVariable @Valid String shortLink) {
        return ResponseEntity.status(302).header("Location", linkService.getOriginalLink(shortLink)).build();
    }

    @GetMapping("/links/count/all")
    public ResponseEntity<Integer> getQtdAllLinksCreated() {
        return ResponseEntity.status(200).body(linkService.getQtdAllLinksCreated());
    }

    @GetMapping("/links/count/today")
    public ResponseEntity<Integer> getQtdLinksCreatedToday() {
        return ResponseEntity.status(200).body(linkService.getQtdLinksCreatedToday());
    }
}
