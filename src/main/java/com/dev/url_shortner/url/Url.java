package com.dev.url_shortner.url;

import com.dev.url_shortner.user.User;
import jakarta.persistence.*;

@Entity
@Table
public class Url {

    @Id
    @SequenceGenerator(name = "url_sequence", sequenceName = "url_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_sequence")

    private Long id;
    private String longUrl;
    private String shortUrl;
    private String userEmail;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public Url(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public Url(Long id, String longUrl, String shortUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public Url(Long id, String longUrl, String shortUrl, User user) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.user = user;
    }

    public Url(String longUrl, String shortUrl, User user) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.user = user;
    }

    public Url(String longUrl, User user) {
        this.longUrl = longUrl;
        this.user = user;
    }

    public Url() {
    }

    public Url(Long id, String longUrl, String shortUrl, String userEmail) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", user=" + user +
                '}';
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
