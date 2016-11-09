package com.dao;

import java.util.List;

import com.entities.Users;

public interface UserDao {
	public List<Users> selectList();
	public boolean delete(Users users);
	public boolean saveOrUpdate(Users users);
}
