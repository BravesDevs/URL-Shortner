package com.dev.url_shortner.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    private final UrlRepository urlRepository;


    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<Url> getUrls() {
        return urlRepository.findAll();
    }

    public void addNewUrl(Url url) {
        try {
            String longUrl = url.getLongUrl();
            if (longUrl.isEmpty()) {
                throw new IllegalStateException("Url cannot be empty");
            }
            String shortUrl = "https://short.url/" + longUrl.hashCode();
            url.setShortUrl(shortUrl);
            urlRepository.save(url);
        } catch (Exception e) {
            throw new IllegalStateException("Something went wrong. Please try again.");
        }
    }

}
