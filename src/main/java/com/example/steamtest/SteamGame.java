package com.example.steamtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamGame {
    private String name;
    private String detailedDescription;
    private String headerImage;


}
