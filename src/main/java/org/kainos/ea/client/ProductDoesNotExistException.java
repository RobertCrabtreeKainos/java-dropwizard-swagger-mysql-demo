package org.kainos.ea.client;

public class ProductDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "Product not found in db";
    }
}
