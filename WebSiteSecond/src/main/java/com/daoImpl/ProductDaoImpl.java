package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.entities.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		List<Product> listProduct = sessionFactory.getCurrentSession().createQuery("from Product").list();
		return listProduct;
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

}
