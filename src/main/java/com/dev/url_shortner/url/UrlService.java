package com.dev.url_shortner.url;

import com.dev.url_shortner.user.UserRepository;
import java.lang.Math;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.url_shortner.url.Helpers;
import java.util.List;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final UserRepository userRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository, UserRepository userRepository) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
    }

    public List<Url> getUrls() {
        return urlRepository.findAll();
    }

    public Url addNewUrl(Url url) {
        try {
            if (url.getLongUrl().isEmpty()) {
                throw new IllegalStateException("Long URL cannot be empty");
            }

            if (url.getUser().getEmail().isEmpty()) {
                throw new IllegalStateException("User email cannot be empty");
            }

            String shortUrl = Helpers.generateShortUrl(url.getLongUrl(), url.getUser().getEmail());
            url.setShortUrl(shortUrl);

            boolean userExists = userRepository.existsByEmail(url.getUser().getEmail());

            if (!userExists) {
                System.out.println("User with email " + url.getUser().getEmail() + " does not exist");
                throw new IllegalStateException("User with email " + url.getUser().getEmail() + " does not exist");
            }

            url.setUser(userRepository.findUserByEmail(url.getUser().getEmail()));

            // Save and select the saved url
            Url response = urlRepository.save(url);
            return new Url(response.getId(), response.getLongUrl(), response.getShortUrl(),
                    response.getUser());
        } catch (Exception e) {
            throw new IllegalStateException("Something went wrong. Please try again.");
        }
    }

    @SuppressWarnings("null")
    public void deleteUrl(Long urlId) {
        try {
            boolean exists = urlRepository.existsById(urlId);
            if (!exists) {
                throw new IllegalStateException("Url with id " + urlId + " does not exist");
            }
            urlRepository.deleteById(urlId);
        } catch (Exception e) {
            throw new IllegalStateException("Something went wrong. Please try again.");
        }
    }

}
