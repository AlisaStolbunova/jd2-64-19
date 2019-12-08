package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();


    void addNewProduct(Product product);
}
