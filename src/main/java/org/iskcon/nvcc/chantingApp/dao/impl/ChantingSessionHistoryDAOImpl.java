/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.iskcon.nvcc.chantingApp.dao.ChantingSessionHistory;
import org.iskcon.nvcc.chantingApp.dao.ChantingSessionHistoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author MA041SH
 *
 */
@Repository
public class ChantingSessionHistoryDAOImpl implements ChantingSessionHistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveNewChantingSessionHistory(
			ChantingSessionHistory chantingSessionHistory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(chantingSessionHistory);
		return false;
	}

}
