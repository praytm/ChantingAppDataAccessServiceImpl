/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.iskcon.nvcc.chantingApp.dao.ChantingSessionHistory;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.iskcon.nvcc.chantingApp.dao.UserStatisticsDAO;
import org.iskcon.nvcc.chantingApp.dao.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MA041SH
 *
 */
@Repository
public class UserStatisticsDAOImpl implements UserStatisticsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Integer getNumberOfActiveUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Long val = (Long) session
				.createCriteria(User.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("userStatus", UserStatus.ACTIVE.toString()))
				.uniqueResult();
		return val != null ? val.intValue() : 0;
	}

	public Integer getNumberOfAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Long val = (Long) session.createCriteria(User.class)
				.setProjection(Projections.rowCount()).uniqueResult();
		return val != null ? val.intValue() : 0;
	}

	public Integer getTotalNumberOfBeadsForUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Long val = (Long) session.createCriteria(ChantingSessionHistory.class)
				.setProjection(Projections.sum("numberOfBeads"))
				.add(Restrictions.eq("user", user)).uniqueResult();
		return val != null ? val.intValue() : 0;
	}

	public Integer getTodaysNumberOfBeadsForUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dateArgument = sdf.format(todaysDate);
		Long val = (Long) session
				.createCriteria(ChantingSessionHistory.class)
				.setProjection(Projections.sum("numberOfBeads"))
				.add(Restrictions.eq("chantingSessionDate", new Date(
						dateArgument))).add(Restrictions.eq("user", user))
				.uniqueResult();
		return val != null ? val.intValue() : 0;
	}

	public void insertRecord() {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class, 3);
		ChantingSessionHistory chantingSessionHistory = new ChantingSessionHistory();
		chantingSessionHistory.setChantingSessionDate(new Date());
		chantingSessionHistory.setChantingSessionEndTime(new Date());
		chantingSessionHistory.setChantingSessionStartTime(new Date());
		chantingSessionHistory.setNumberOfBeads(25);
		chantingSessionHistory.setUser(user);

		session.save(chantingSessionHistory);
	}

	public User loadUser(Integer id) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

}
