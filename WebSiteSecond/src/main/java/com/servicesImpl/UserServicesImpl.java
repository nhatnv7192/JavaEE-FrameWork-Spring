package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entities.Users;
import com.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	public List<Users> selectList() {
		// TODO Auto-generated method stub
		return userDao.selectList();
	}

	@Transactional
	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		try {
			userDao.delete(users);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		try {
			userDao.saveOrUpdate(users);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	

}
