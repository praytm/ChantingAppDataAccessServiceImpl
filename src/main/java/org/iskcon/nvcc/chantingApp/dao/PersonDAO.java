package org.iskcon.nvcc.chantingApp.dao;

import java.util.List;



public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
	public void saveTxCheck();
	
}
