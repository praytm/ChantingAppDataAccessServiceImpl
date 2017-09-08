package org.iskcon.nvcc.chantingApp.dao.main;

import org.iskcon.nvcc.chantingApp.dao.User;
import org.iskcon.nvcc.chantingApp.dao.impl.UserStatisticsDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		UserStatisticsDAOImpl userStatisticsDAO = context.getBean(UserStatisticsDAOImpl.class);
	//	User user = userStatisticsDAO.loadUser(1);
		// Integer count = userStatisticsDAO.getTodaysNumberOfBeadsForUser(user, null);
		 
		 Integer count = userStatisticsDAO.getTotalNumberOfBeadsForToday();
		System.out.println("count is  "+count);
		context.close();
		
	}

}
