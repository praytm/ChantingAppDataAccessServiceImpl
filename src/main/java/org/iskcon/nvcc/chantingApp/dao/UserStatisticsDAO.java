/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

import java.util.Date;
import java.util.Map;

/**
 * @author MA041SH
 *
 */
public interface UserStatisticsDAO {

	public Integer getNumberOfActiveUsers();
	
	public Integer getNumberOfAllUsers();
	
	public Integer getTotalNumberOfBeadsForUser(User user);
	
	public Integer getTodaysNumberOfBeadsForUser(User user, Date dateInput);
	
	public Map<String, Integer> getChantingHistoryForUser(User user,
			Date dateInput);
	
	public Integer getTotalNumberOfBeadsForToday();
	
	public String getValueFromMasterData(String key);
	
	
}
