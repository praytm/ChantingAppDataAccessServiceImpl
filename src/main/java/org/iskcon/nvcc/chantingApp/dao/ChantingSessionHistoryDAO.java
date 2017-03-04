/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

/**
 * @author MA041SH
 *
 */
public interface ChantingSessionHistoryDAO {

	
	/**
	 * Insert a new record for a particular user in ChantingSessionHistory
	 * @param chantingSessionHistory
	 * @return
	 */
	public boolean saveNewChantingSessionHistory(ChantingSessionHistory chantingSessionHistory);
}
