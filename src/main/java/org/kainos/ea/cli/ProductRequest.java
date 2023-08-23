package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductRequest {
    @JsonCreator
    public ProductRequest(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("price") double price
    ){
        this.Name = name;
        this.Description = description;
        this.Price = price;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    private String Name;
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    private String Description;
    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }
    private  double Price;
}
