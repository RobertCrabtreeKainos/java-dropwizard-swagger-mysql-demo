package org.kainos.ea.api;

import org.eclipse.jetty.server.Authentication;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.OrderDao;
import org.kainos.ea.db.ProductDao;

import java.sql.SQLException;
import java.util.*;

public class ProductService {
    private ProductDao productDao = new ProductDao();
    private ProductValidator productValidator = new ProductValidator();

    public List<Product> getAllProducts() throws FailedToGetProductException {

        List<Product> productList = null;
        try {
            productList = productDao.getAllProducts();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetProductException();
        }

        return productList;
    }
    public Product getProductById(int id) throws FailedToGetProductException, ProductDoesNotExistException {
        try{
            Product product = productDao.getProductById(id);
            if(product == null) {
                throw new ProductDoesNotExistException();
            }
            return product;
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw new FailedToGetProductException();
        }
    }
    public int createProduct(ProductRequest product) throws FailedToCreateProductException, InvalidProductException {
        try{
            String validation = productValidator.isValidProduct(product);
            if(validation != null)
            {
                throw new InvalidProductException(validation);
            }
            int id = productDao.createProduct(product);
            if (id == -1){
                throw new FailedToCreateProductException();
            }
            return id;
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
            throw new FailedToCreateProductException();
        }
    }
    public void updateProduct(int id, ProductRequest product) throws InvalidProductException, ProductDoesNotExistException, FailedToUpdateProductException
    {
        try{
            String validation = productValidator.isValidProduct(product);

            if(validation != null)
            {
                throw new InvalidProductException(validation);
            }
            Product productToUpdate = productDao.getProductById(id);
            System.out.println(productToUpdate);
            System.out.println(id);
            if(productToUpdate == null)
            {
                throw new ProductDoesNotExistException();
            }
            productDao.updateProduct(id, product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteProduct(int id) throws ProductDoesNotExistException, FailedToDeleteProductException{
        try{
            Product productToDelete = productDao.getProductById(id);
            if(productToDelete == null)
            {
                throw new ProductDoesNotExistException();
            }
            productDao.deleteProduct(id);
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            throw new FailedToDeleteProductException();
        }
    }
}
