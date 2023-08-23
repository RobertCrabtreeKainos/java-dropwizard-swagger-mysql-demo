package org.kainos.ea.cli;

import java.text.DecimalFormat;

public class Product {
    public Product(String Description, String Name, int ProductId, double Price)
    {
        this.Description = Description;
        this.Name = Name;
        this.ProductId = ProductId;
        this.Price = Price;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private int ProductId;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    private String Description;

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    private double Price;
}
