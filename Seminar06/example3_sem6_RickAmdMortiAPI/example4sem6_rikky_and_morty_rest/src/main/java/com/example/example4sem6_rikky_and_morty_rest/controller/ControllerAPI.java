package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/characters")
    public String getCharacters(Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        List<Result> results = allCharacters.getResults();
        model.addAttribute("characters", results);
        return "characters";
    }
    @GetMapping("/character/{id}")
    public String getSingleCharacter(@PathVariable Integer id, Model model)
    {
        Result character = serviceApi.getSingleCharacter(id);
        model.addAttribute("character", character);
        return "character";
    }
}
