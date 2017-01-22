/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	
	
	public User registerUser(User userInput){
		Session session = this.sessionFactory.getCurrentSession();
		Object obj =session.save(userInput);
		Integer savedUserId = (Integer) obj;
		
		return (User) session.get(User.class, savedUserId);
	}
}
