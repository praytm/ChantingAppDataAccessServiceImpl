package com.journaldev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		// Transaction tx = session.beginTransaction();
		session.persist(p);
		// tx.commit();
		// session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personList = session.createQuery("from Person").list();
		return personList;
	}

	public void saveTxCheck() {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = new Person();
		person.setName("Txcheck");
		person.setCountry("Germany");
		session.persist(person);
		

	}

}
