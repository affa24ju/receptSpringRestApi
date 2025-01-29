package com.receptSpringRestApi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receptSpringRestApi.api.model.Receipe;
import com.receptSpringRestApi.service.ReceipeService;

@RestController
@RequestMapping("/api/favorites")
public class ReceipeController {

    private ReceipeService receipeService;

    @Autowired
    public ReceipeController(ReceipeService receipeService){
        this.receipeService = receipeService;
    }

    //Hämta alla favorit recept
    @GetMapping
    public List<Receipe> getAllFavorites(){
        return receipeService.readFavorites();
    }
    
}
