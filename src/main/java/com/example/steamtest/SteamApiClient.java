package com.example.steamtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SteamApiClient {

    @Value("${steam.api.key}") // Подставьте ваш API ключ Steam из application.properties
    private String apiKey;

    @Autowired
    SteamGameMapper steamGameMapper;
    private final RestTemplate restTemplate;


    public SteamApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public SteamGame getGameDescription(long appId) {
        System.out.println("In get desctiption method");
        String url = "https://store.steampowered.com/api/appdetails?appids=" + appId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        //return  response.getBody();
        return steamGameMapper.mapSteamGame(response.getBody());
    }
}