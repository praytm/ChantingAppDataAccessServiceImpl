/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.iskcon.nvcc.chantingApp.dao.RegistrationDAO;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MA041SH
 *
 */
@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public User registerUser(User userInput) {
		System.out.println("userInput is ::::::::"+userInput);
		if(null == userInput.getIsRegisteredViaGoogle()){
			// data is incomplete so returning userInput as it is with null userId
			return userInput;
		}
		if(userInput.getIsRegisteredViaGoogle() && (null == userInput.getGoogleAuthToken() || userInput.getGoogleAuthToken().isEmpty())){
		// data is incomplete so returning userInput as it is with null userId
			return userInput;
		}
			
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Criteria> list = session.createCriteria(User.class)
				.add(Restrictions.eq("email", userInput.getEmail())).list();
		if (list.isEmpty()) {			
			session.save(userInput);
			return userInput;
		} else {
			return null;
		}

	}
}
