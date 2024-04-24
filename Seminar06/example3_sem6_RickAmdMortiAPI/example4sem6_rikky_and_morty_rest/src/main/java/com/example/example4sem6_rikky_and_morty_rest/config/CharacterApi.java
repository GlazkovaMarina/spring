package com.example.example4sem6_rikky_and_morty_rest.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@Data
@ConfigurationProperties(prefix = "character")
public class CharacterApi {
    private String api;
}
