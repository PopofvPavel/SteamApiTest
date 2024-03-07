package com.example.steamtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {

    private final SteamApiClient steamApiClient;

    public GameController(SteamApiClient steamApiClient) {
        this.steamApiClient = steamApiClient;
    }

    @GetMapping("/game/{appId}")
    public SteamGame getGameDescription(@PathVariable long appId) {
        return steamApiClient.getGameDescription(appId);
    }
}