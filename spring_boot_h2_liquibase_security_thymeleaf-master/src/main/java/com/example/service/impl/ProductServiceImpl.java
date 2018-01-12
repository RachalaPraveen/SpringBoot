package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return repository.save(product);
    }

    @Override
    public Product findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
