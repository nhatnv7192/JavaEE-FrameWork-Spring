package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Category;

public interface CategoryServices {
	public List<Category> selectList();
	public boolean saveOrUpdate(Category category);
	public boolean delete(Category category);
}
