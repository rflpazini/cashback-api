package com.rflpazini.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rflpazini.model.Users;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Users> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Users> usersList = session.createQuery("from Users").list();
		return usersList;
	}

	public Users getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users user = (Users) session.get(Users.class, new Integer(id));
		return user;
	}

	public Users getUserByCpf(String cpf) {
		Session session = this.sessionFactory.getCurrentSession();
		String queryString = "from Users where user_cpf = :cpf";
		Query query = session.createQuery(queryString);
		query.setString("cpf", cpf);
		Object queryResult = query.uniqueResult();
		Users user = (Users) queryResult; 
		return user;
	}

	public Users addUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}

	public void updateUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Users user = (Users) session.load(Users.class, new Integer(id));
		if (user != null) {
			session.delete(user);
		}
	}

}
