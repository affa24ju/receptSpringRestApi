package com.receptSpringRestApi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.receptSpringRestApi.api.model.Receipe;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReceipeService {


    private static final String FILE_PATH = "favorites.json";
    private List<Receipe> favorites;
    private final ObjectMapper objectMapper;

    public ReceipeService() {
        this.objectMapper = new ObjectMapper();
        this.favorites = loadFavoritesFromFile();
    }

    // Ladda favoriter från fil
    private List<Receipe> loadFavoritesFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                // Läser JSON-data från filen
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Receipe.class));
            } else {
                return new ArrayList<>(); // Om filen inte finns, skapar en tom lista
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Sparar favoriter till fil
    private void saveFavoritesToFile() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), favorites);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hämtar alla favoriter
    public List<Receipe> readFavorites() {
        return favorites;
    }

    // Lägg till ett favorit
    public Receipe addFavorite(Receipe receipe) {
        favorites.add(receipe);
        saveFavoritesToFile(); // Spara tillbaka till filen
        return receipe;
    }

    // Ta bort ett favorit
    public boolean removeFavorite(int id) {

        boolean removed = favorites.removeIf(f -> f.getId() == id);
        if (removed){
            saveFavoritesToFile();//Sparar till fil efter uppdatering
        }
        return removed;
    }
    //Ändra/uppdatera ett favorit, håller på att bygga men inte färdigt än
    //Kommenterat bort PutMapping från cnotroller
    public boolean updateFavorite(int id, Receipe updatedReceipe){
        for (int i = 0; i < favorites.size(); i++){
            Receipe existingReceipe = favorites.get(i);
            if (existingReceipe.getId() == id){
                //uppdaterar
                favorites.set(i, updatedReceipe);
                saveFavoritesToFile(); //Sparar i fil
                return true;//true if lyckad uppdatering
            }
        }
        return false; //Returnerar false om inte matchar
    }
}

