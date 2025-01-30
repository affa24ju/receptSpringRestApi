package com.receptSpringRestApi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receptSpringRestApi.api.model.Receipe;
import com.receptSpringRestApi.service.ReceipeService;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "http://localhost:8080")
public class ReceipeController {


    @Autowired
    private ReceipeService receipeService;

    //@Autowired
    public ReceipeController(ReceipeService receipeService){
        this.receipeService = receipeService;
    }

    //Hämta alla favorit recept
    @GetMapping
    public List<Receipe> getAllFavorites(){
        return receipeService.readFavorites();
    }
    //Post metod för att lägga till favorit
    @PostMapping
    public Receipe addFavorite(@RequestBody Receipe receipe){
        return receipeService.addFavorite(receipe);
    }

    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
    
}
