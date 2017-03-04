/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.iskcon.nvcc.chantingApp.dao.LoginDAO;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MA041SH
 *
 */
@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAOImpl.class);

	public User loginUser(User userInput) {
		Session session = sessionFactory.getCurrentSession();
		List<Criteria> listUsers = session.createCriteria(User.class)
				.add(Restrictions.eq("email", userInput.getEmail())).list();
		if (listUsers.isEmpty()) {
			//if no matching record found corresponding to input email then return inout as it is 
			logger.info(" user {} does not exist in db ",userInput.getEmail());
			return userInput;
		} else {
			User user = (User) listUsers.get(0);
			if (userInput.getPassword().equals(user.getPassword())) {
				//if matching record is found and also the password matched, then return the user object from db
				logger.info("password provided for user {} did match in db ",userInput.getEmail());
				return user;
			} else {
				//if matching record found but password did not match ,return null
				logger.warn("password provided for user {} did not match in db ",userInput.getEmail());
				return null;
			}
		}
	}
	
	public void updateUser(User user){
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

}
