package com.dev.url_shortner.url;

import java.lang.Math;

public class Helpers {

    public static String generateShortUrl(String longUrl, String userEmail) {
        return "https://short.ly/" + Math.abs((longUrl + userEmail).hashCode());
    }

}
