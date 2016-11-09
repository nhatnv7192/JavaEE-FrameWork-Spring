package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.entities.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Category> selectList() {
		// TODO Auto-generated method stub
		List<Category> listCategory = sessionFactory.getCurrentSession().createQuery("from Category").list();
		return listCategory;
	}

	@Override
	public boolean saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(category);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

}
