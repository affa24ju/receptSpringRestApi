package com.receptSpringRestApi.api.model;


public class Receipe {
    private int id;
    private String name;
    private String imageUrl;
    private String instructions;

    public Receipe(int id, String name, String imageUrl, String instructions) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.instructions = instructions;
    }
//Getters & setters for all  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
