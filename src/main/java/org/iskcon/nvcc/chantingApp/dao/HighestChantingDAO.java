/**
 * 
 */
package org.iskcon.nvcc.chantingApp.dao;

import java.util.Map;

/**
 * @author Shri
 *
 */
public interface HighestChantingDAO {
	
	public Map<User, Integer> getHighestChanting();
}
