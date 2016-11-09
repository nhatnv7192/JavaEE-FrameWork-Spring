package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entities.Users;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Users> selectList() {
		// TODO Auto-generated method stub
		List<Users> listUsers = sessionFactory.getCurrentSession().createQuery("from Users").list();
		return listUsers;
	}

	@Override
	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(users);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(users);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
}
