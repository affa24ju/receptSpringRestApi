package com.receptSpringRestApi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receptSpringRestApi.api.model.Receipe;
import com.receptSpringRestApi.service.ReceipeService;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "http://127.0.0.1:5500")
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
    //Delete metod för att ta bort ett recept från favorit
    @DeleteMapping("/{id}")
    public boolean removeFavorite(@PathVariable int id){
        return receipeService.removeFavorite(id);
    }
    //Ändra på ett favorit
    @PutMapping("/{id}")
    public boolean updateFavorite(@PathVariable int id, @RequestBody Receipe updatedReceipe){
        return receipeService.updateFavorite(id,updatedReceipe);
    }
    //test
    @GetMapping("/test")
    public String test() {
        return "API is working!";
    }
    
}
