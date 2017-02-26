/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

/**
 * @author MA041SH
 *
 */
public interface UserStatusDAO {

	
	/**
	 * change the status of user to active, typically invoked after a user starts a new chanting session
	 * @param user
	 * @return
	 */
	public boolean changeUserStatusToActive(User user);
	
	/**
	 * Change the status of user to inactive, typically invoked after a user finishes a chanting session
	 * @param user
	 * @return
	 */
	public boolean changeUserStatusToNotActive(User user);
}
