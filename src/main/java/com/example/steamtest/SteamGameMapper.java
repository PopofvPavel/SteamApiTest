package com.example.steamtest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SteamGameMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();



    @SneakyThrows
    public SteamGame mapSteamGame(String json) {
        JsonNode rootNode = objectMapper.readTree(json);
        String gameId = rootNode.fieldNames().next(); // Получаем первый (и единственный) ключ из объекта
        JsonNode gameData = rootNode.get(gameId).get("data");
        return new SteamGame(
                gameData.get("name").asText(),
                gameData.get("detailed_description").asText(),
                gameData.get("header_image").asText()
        );
    }
}
