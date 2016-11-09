package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.entities.Product;
import com.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductDao productDao;
	@Transactional
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return productDao.listProduct();
	}

	@Transactional
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product);
	}

	@Transactional
	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return productDao.saveOrUpdate(product);
	}

}
