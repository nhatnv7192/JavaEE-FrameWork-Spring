package com.services;

import java.util.List;

import com.entities.Product;

public interface ProductServices {
	public List<Product> listProduct();
	public boolean deleteProduct(Product product);
	public boolean saveOrUpdate(Product product);
}
