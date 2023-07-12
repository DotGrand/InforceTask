package com.example.webapp.dao;

import com.example.webapp.entity.User;
import org.hibernate.Session;
;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void saveCurrentUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);
    }
}
