/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

/**
 * @author MA041SH
 *
 */
public enum UserStatus {

	/**
	 * Status if user after first time registration
	 */
	REGISTERED,
	
	/**
	 * status of user after starting a chanting session
	 */
	ACTIVE,
	/**
	 * status of user after ending a chanting session
	 */
	NOT_ACTIVE;
	
}
