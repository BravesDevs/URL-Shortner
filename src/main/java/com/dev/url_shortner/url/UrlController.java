package com.dev.url_shortner.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addNewUrl(@RequestBody Url url) {
        System.out.println(url);
        urlService.addNewUrl(url);
    }
}