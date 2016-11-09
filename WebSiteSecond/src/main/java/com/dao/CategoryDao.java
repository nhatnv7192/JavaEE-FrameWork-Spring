package com.dao;

import java.util.List;

import com.entities.Category;

public interface CategoryDao {
	public List<Category> selectList();
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
}
