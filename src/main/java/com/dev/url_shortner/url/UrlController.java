package com.dev.url_shortner.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.url_shortner.exception.ApiRequestException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/url")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping()
    public List<Url> getUrls() {
        return urlService.getUrls();
    }

    @PostMapping(path = "/add")
    public Url addNewUrl(@RequestBody Url url) {
        try {
            return urlService.addNewUrl(url);

        } catch (Exception e) {
            throw new ApiRequestException("Cannot add new URL", e);
        }
    }

    @DeleteMapping(path = "/delete/{urlId}")
    public void deleteUrl(@PathVariable("urlId") Long urlId) {
        urlService.deleteUrl(urlId);
    }
}
