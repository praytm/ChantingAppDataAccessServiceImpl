/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.iskcon.nvcc.chantingApp.dao.UserStatus;
import org.iskcon.nvcc.chantingApp.dao.UserStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MA041SH
 *
 */
@Repository
public class UserStatusDAOImpl implements UserStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean changeUserStatusToActive(User userInput) {
		System.out.println("userInput is ::::::::" + userInput);
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = session.createCriteria(User.class)
				.add(Restrictions.eq("email", userInput.getEmail())).list();
		if (list.isEmpty()) {
			return false;
		} else {
			User user = list.get(0);
			user.setUserStatus(UserStatus.ACTIVE.toString());
			return true;
		}

	}

	public boolean changeUserStatusToNotActive(User userInput) {
		System.out.println("userInput is ::::::::" + userInput);
		Session session = this.sessionFactory.getCurrentSession();
		List<User> list = session.createCriteria(User.class)
				.add(Restrictions.eq("email", userInput.getEmail())).list();
		if (list.isEmpty()) {
			return false;
		} else {
			User user = list.get(0);
			user.setUserStatus(UserStatus.NOT_ACTIVE.toString());
			return true;
		}

	}
}
