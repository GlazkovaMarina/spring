package com.example.example4sem6_rikky_and_morty_rest.service;

import com.example.example4sem6_rikky_and_morty_rest.config.CharacterApi;
import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@AllArgsConstructor
@Service
public class ServiceApiImpl implements ServiceApi{

    private RestTemplate template;

    private HttpHeaders headers;

    private CharacterApi characterApi;

//    private  static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> responce = template.exchange(characterApi.getApi(), HttpMethod.GET,entity, Characters.class);
        return responce.getBody();
    }

    @Override
    public Result getSingleCharacter(Integer id){
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String path = characterApi.getApi().concat("/").concat(String.valueOf(id));
        ResponseEntity<Result> responce = template.exchange(path, HttpMethod.GET, entity,Result.class);
        return responce.getBody();
    }
}
