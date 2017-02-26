/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

/**
 * @author MA041SH
 *
 */
public interface UserStatisticsDAO {

	public Integer getNumberOfActiveUsers();
	
	public Integer getNumberOfAllUsers();
	
	public Integer getTotalNumberOfBeadsForUser(User user);
	
	public Integer getTodaysNumberOfBeadsForUser(User user);
	
	
}
