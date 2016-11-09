package com.dao;

import java.util.List;

import com.entities.Product;

public interface ProductDao {
	public List<Product> listProduct();
	public boolean deleteProduct(Product product);
	public boolean saveOrUpdate(Product product);
}
