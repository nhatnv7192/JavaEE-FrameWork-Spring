package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.entities.Category;
import com.services.CategoryServices;

@Service
public class CategoryServicesImpl implements CategoryServices{
	@Autowired
	CategoryDao categoryDao;

	@Transactional
	public List<Category> selectList() {
		// TODO Auto-generated method stub
		return categoryDao.selectList();
	}

	@Transactional
	public boolean saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.delete(category);
	}

	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.saveOrUpdate(category);
	}
	
}
