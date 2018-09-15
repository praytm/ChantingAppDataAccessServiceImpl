package org.iskcon.nvcc.chantingApp.dao.impl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iskcon.nvcc.chantingApp.dao.HighestChantingDAO;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.springframework.beans.factory.annotation.Autowired;

public class HighestChantingDAOImpl implements HighestChantingDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Map<User, Integer> getHighestChanting() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return null;
	}
	
}
