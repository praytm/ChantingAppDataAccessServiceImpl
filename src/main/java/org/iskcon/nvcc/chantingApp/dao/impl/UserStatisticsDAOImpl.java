/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.iskcon.nvcc.chantingApp.dao.ChantingSessionHistory;
import org.iskcon.nvcc.chantingApp.dao.Masterdata;
import org.iskcon.nvcc.chantingApp.dao.User;
import org.iskcon.nvcc.chantingApp.dao.UserStatisticsDAO;
import org.iskcon.nvcc.chantingApp.dao.UserStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * 
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(UserStatisticsDAOImpl.class);

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
	
	public Integer getTotalNumberOfBeadsForToday(){
		Session session = this.sessionFactory.getCurrentSession();
	//	Session session = this.sessionFactory.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dateArgument = sdf.format(new Date());
		Long val = (Long) session.createCriteria(ChantingSessionHistory.class)
				.setProjection(Projections.sum("numberOfBeads"))
				.add(Restrictions.eq("chantingSessionDate", new Date(dateArgument))).uniqueResult();
		
		return val != null ? val.intValue() : 0;
	}
	
	public String getValueFromMasterData(String key){
		System.out.println("Key isssssssssssssssssssssssssssss "+key);
		Session session = this.sessionFactory.getCurrentSession();
	//	Session session = this.sessionFactory.openSession();
		Masterdata val = (Masterdata) session.createCriteria(Masterdata.class)
				.add(Restrictions.eq("key", key)).uniqueResult();		
		return val.getValue();
		
	}

	public Integer getTodaysNumberOfBeadsForUser(User user, Date dateInput) {
		
		Session session = this.sessionFactory.getCurrentSession();

		Date todaysDate = (dateInput == null) ? new Date() : dateInput;
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

	public Map<String, Integer> getChantingHistoryForUser(User user,
			Date dateInput) {
		Map<String, Integer> outputMap = new HashMap<String, Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date today = (dateInput == null) ? new Date() : dateInput;
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		for (int i = 0; i <= 30; i++) {
			if(i != 0){
				cal.add(Calendar.DAY_OF_MONTH, -1);	
			}			
			Date dateToBeQueried = cal.getTime();
			logger.info("dateToBeQueried for getting chanting history is {}",dateToBeQueried);
			Integer numOfBeads = getTodaysNumberOfBeadsForUser(user,
					dateToBeQueried);
			String dateMapKey = sdf.format(dateToBeQueried);
			// check in database if more than 30th date from input date record
			// exists ,then send the last map key as indicator of this and value
			// for this key as null
			// temporarily disabled this logic till functional requirements are clear
/*			if (i == 30 && numOfBeads != 0) {
				dateMapKey = "MoreThanThirtyDaysRecordsExist";
				numOfBeads = null;
			}*/
			outputMap.put(dateMapKey, numOfBeads);
		}
		return outputMap;
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
