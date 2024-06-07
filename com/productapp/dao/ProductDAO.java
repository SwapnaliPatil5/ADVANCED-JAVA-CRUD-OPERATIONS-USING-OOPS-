package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface ProductDAO {
   int save(Product product);
   List<Product> getAll();
   Product getById(int id);
   int remove(int id);
   int update(int id, Product product);
}
