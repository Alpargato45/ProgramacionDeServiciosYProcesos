package com.mycompany.principal;

public class Producto {
    
    private String title;
    private float price;
    private String description;
    private String image;

    public Producto(String title, float price, String description, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getTittle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
