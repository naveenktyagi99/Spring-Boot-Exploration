package com.springboot.exploration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.exploration.dao.AbstractDAOTemplate;
import com.springboot.exploration.dao.UserDao;
import com.springboot.exploration.model.User;

/**
 * Class implements the User DAO Methods
 * 
 * @author naveen.tyagi
 *
 */

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDAOTemplate<User, Long> implements UserDao {

	@Override
	public void addUser(User user) {

		getSession().save(user);
	}

	@Override
	public User getUser(Long id) {
		return null;
	}

	@Override
	public User deleteById(Long id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return createEntityQuery("from User").list();
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public boolean authenticate(User user) {

		String hql = "FROM User AS user WHERE user.username=:username and user.password=:password";

		return !(createEntityQuery(hql).setParameter("username", user.getUsername())
				.setParameter("password", user.getPassword()).list()).isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User userByUsername(String username) {
		Criteria criteria = createEntityCriteria("User");
		criteria.add(Restrictions.eq("username", username));
		List<User> userList = criteria.list();
		if (!userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}
}
