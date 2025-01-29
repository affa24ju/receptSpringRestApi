package com.receptSpringRestApi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.receptSpringRestApi.api.model.Receipe;

@Service
public class ReceipeService {

    private List<Receipe> favorites;

    public List<Receipe> readFavorites(){
        return favorites;
    }
    
}
