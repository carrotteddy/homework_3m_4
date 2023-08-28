package com.example.homework_3m_4;

public class Country {
    private String imageURI;
    private String name;

    public Country(String imageURI, String name) {
        this.imageURI = imageURI;
        this.name = name;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
